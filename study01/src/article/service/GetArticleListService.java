package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import article.dao.ArticleDao1;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class GetArticleListService {
	private static GetArticleListService instance = new GetArticleListService();

	public static GetArticleListService getInstance() {
		return instance;
	}

	private GetArticleListService() {
	}

	private static final int ARTICLE_COUNT_PER_PAGE = 3;

	public ArticleListView getArticleList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		try {
			conn = ConnectionProvider.getConnection();
			ArticleDao1 articleDao = ArticleDao1.getInstance();

			int articleTotalCount = articleDao.selectCount(conn);

			List<Article> articleList = null;
			int firstRow = 0;
			int endRow = 0;
			if (articleTotalCount > 0) {
				firstRow =
						(pageNumber - 1) * ARTICLE_COUNT_PER_PAGE + 1;
				endRow = firstRow + ARTICLE_COUNT_PER_PAGE - 1;
				articleList =
						articleDao.selectList(conn, firstRow, endRow);
			} else {
				currentPageNumber = 0;
				articleList = Collections.emptyList();
			}
			return new ArticleListView(articleList,
					articleTotalCount, currentPageNumber,
					ARTICLE_COUNT_PER_PAGE, firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}