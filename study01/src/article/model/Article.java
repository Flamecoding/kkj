package article.model;

import java.util.Date;

public class Article {

	private int id;
	private String title;
	private String content;
	private String createdBy;
	private Date createdDt;
	private String modifiedBy;
	private Date modifiedDt;
	
	public Article(Integer id, String title, String content, String createdBy,  Date createdDt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
}
