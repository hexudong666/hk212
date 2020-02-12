package com.gengjiaxin.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gengjiaxin.practice.dao.PracticeDao;
import com.gengjiaxin.practice.domain.Practice;
import com.gengjiaxin.practice.service.PracticeService;
@Service
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private PracticeDao dao;

	@Override
	public List<Practice> list() {
		return dao.list();
	}

	@Override
	public Integer publisher(Practice practice) {
		return dao.publisher(practice);
	}

	
}
