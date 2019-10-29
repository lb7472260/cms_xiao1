package com.libo.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.libo.cms.dao.SpecialMapper;
import com.libo.cms.domain.Special;
import com.libo.cms.service.SpecialService;

@Service
public class SpecialServiceImpl implements SpecialService {
	
	@Resource
	SpecialMapper specialMapper;
	
	@Override
	public List<Special> listSpecial() {
		// TODO Auto-generated method stub
		return specialMapper.listSpecial();
	}

	@Override
	public Special getSpecial(Integer specialId) {
		// TODO Auto-generated method stub
		return specialMapper.getSpecial(specialId);
	}

	@Override
	public int removeArticle(Integer articleID, Integer specialID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("specialID",specialID);
		map.put("articleID",articleID);
		System.out.println("specialID :"+specialID+"   articleID :"+ articleID);
		return specialMapper.removeArticle(map);
	}

	@Override
	public int addArticle(Integer articleID, Integer specialID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("specialID",specialID);
		map.put("articleID",articleID);
		
		return specialMapper.addArticle(map);
	}

	@Override
	public void addSpecial(Special special) {
		specialMapper.addSpecial(special);
	}

	@Override
	public void updateSpecial(Special special) {
		specialMapper.updateSpecial(special);
		
	}

}
