package com.mykheikin.manager.service;

import java.util.List;

import com.mykheikin.manager.model.Sex;

public interface SexService {
	
	Sex findById(int id);

	List<Sex> findAllSex();
}
