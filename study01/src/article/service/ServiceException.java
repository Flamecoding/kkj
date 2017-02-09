package article.service;

public class ServiceException extends RuntimeException {

	public ServiceException(String article, Exception cause) {
		super(article, cause);
	}

	public ServiceException(String article) {
		super(article);
	}

}