package com.gengjiaxin.practice.service;

import java.util.List;

import com.gengjiaxin.practice.domain.Practice;

public interface PracticeService {

	public List<Practice> list();

	public Integer publisher(Practice practice);

}
