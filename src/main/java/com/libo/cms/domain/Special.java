package com.libo.cms.domain;

import java.util.Date;
import java.util.List;

public class Special {
	private Integer id;
	private String title;
	private String abstracts;
	private Date created;
	public List<Special_Article> middleList;
	public Special() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Special(Integer id, String title, String abstracts, Date created, List<Special_Article> middleList) {
		super();
		this.id = id;
		this.title = title;
		this.abstracts = abstracts;
		this.created = created;
		this.middleList = middleList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public List<Special_Article> getMiddleList() {
		return middleList;
	}
	public void setMiddleList(List<Special_Article> middleList) {
		this.middleList = middleList;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", title=" + title + ", abstracts=" + abstracts + ", created=" + created
				+ ", middleList=" + middleList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abstracts == null) ? 0 : abstracts.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((middleList == null) ? 0 : middleList.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Special other = (Special) obj;
		if (abstracts == null) {
			if (other.abstracts != null)
				return false;
		} else if (!abstracts.equals(other.abstracts))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (middleList == null) {
			if (other.middleList != null)
				return false;
		} else if (!middleList.equals(other.middleList))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}
