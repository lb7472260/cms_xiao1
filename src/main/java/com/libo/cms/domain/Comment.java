package com.libo.cms.domain;

import java.util.Date;

public class Comment {
private Integer id;
/**作者**/
private User author;
/**文章**/
private Article article;
/**内容**/
private String content;
/**创建时间**/
private Date created;
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
public Comment(Integer id, User author, Article article, String content, Date created) {
	super();
	this.id = id;
	this.author = author;
	this.article = article;
	this.content = content;
	this.created = created;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public User getAuthor() {
	return author;
}
public void setAuthor(User author) {
	this.author = author;
}
public Article getArticle() {
	return article;
}
public void setArticle(Article article) {
	this.article = article;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
@Override
public String toString() {
	return "Comment [id=" + id + ", author=" + author + ", article=" + article + ", content=" + content + ", created="
			+ created + "]";
}


}
