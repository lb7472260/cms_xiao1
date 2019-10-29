package com.libo.cms.domain;

public class Special_Article {
	private Integer sid;
	private Integer aid;
	private Article article;
	public Special_Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Special_Article(Integer sid, Integer aid, Article article) {
		super();
		this.sid = sid;
		this.aid = aid;
		this.article = article;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public String toString() {
		return "Special_Article [sid=" + sid + ", aid=" + aid + ", article=" + article + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Special_Article other = (Special_Article) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	


}
