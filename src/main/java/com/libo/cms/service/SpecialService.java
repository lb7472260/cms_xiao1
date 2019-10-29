package com.libo.cms.service;

import java.util.List;

import com.libo.cms.domain.Special;

public interface SpecialService {

	public List<Special> listSpecial();

	public Special getSpecial(Integer specialId);

	public int removeArticle(Integer articleID, Integer specialID);

	public int addArticle(Integer articleID, Integer specialID);

	public void addSpecial(Special special);

	public void updateSpecial(Special special);

}
