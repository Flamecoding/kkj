package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao1 {

	private static ArticleDao1 articleDao = new ArticleDao1();
	public static ArticleDao1 getInstance() {
		return articleDao;
	}
	
	private ArticleDao1() {}
	
	public Article select(Connection conn, int articleId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from article where article_id = ?");
			pstmt.setInt(1, articleId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return makeArticleFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Article makeArticleFromResultSet(ResultSet rs) throws SQLException {
		/*Article article = new Article();
		article.setId(rs.getInt("article_id"));
		article.setTitle(rs.getString("article_title"));
		article.setContent(rs.getString("article_content"));
		article.setCreatedBy(rs.getString("article_created_by"));
		article.setCreatedDt(rs.getDate("article_created_dt"));
		article.setModifiedBy(rs.getString("article_modified_by"));
		article.setModifiedDt(rs.getDate("article_modified_dt"));*/
		
		return null;
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from article");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Article> selectList(Connection conn, int firstRow, int endRow) 
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from article " + 
					"order by article_id desc limit ?, ?");
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Article> articleList = new ArrayList<Article>();
				do {
					articleList.add(makeArticleFromResultSet(rs));
				} while (rs.next());
				return articleList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
