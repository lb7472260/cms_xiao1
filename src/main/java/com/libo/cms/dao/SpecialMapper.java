package com.libo.cms.dao;

import java.util.List;
import java.util.Map;

import com.libo.cms.domain.Special;

public interface SpecialMapper {

	//进入后台专题管理页面
	List<Special> listSpecial();

	Special getSpecial(Integer specialId);

	int removeArticle(Map<String, Object> map);

	int addArticle(Map<String, Object> map);

	void addSpecial(Special special);

	void updateSpecial(Special special);

}
