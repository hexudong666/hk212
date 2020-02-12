package com.gengjiaxin.practice.dao;

import java.util.List;

import com.gengjiaxin.practice.domain.Practice;

public interface PracticeDao {
	
	public List<Practice> list();
	
	public Integer publisher(Practice practice);
}
