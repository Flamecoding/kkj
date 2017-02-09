package article.service;

import java.util.List;

import article.model.Article;

public class ArticleListView {

	private int articleTotalCount;
	private int currentPageNumber;
	private List<Article> articleList;
	private int pageTotalCount;
	private int articleCountPerPage;
	private int firstRow;
	private int endRow;

	public ArticleListView(List<Article> articleList, int articleTotalCount, 
			int currentPageNumber, int articleCountPerPage, 
			int startRow, int endRow) {
		this.articleList = articleList;
		this.articleTotalCount = articleTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.articleCountPerPage = articleCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;

		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if (articleTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = articleTotalCount / articleCountPerPage;
			if (articleTotalCount % articleCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getArticleCountPerPage() {
		return articleCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public boolean isEmpty() {
		return articleTotalCount == 0;
	}
}