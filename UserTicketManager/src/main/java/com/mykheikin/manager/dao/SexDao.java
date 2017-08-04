package com.mykheikin.manager.dao;

import java.util.List;

import com.mykheikin.manager.model.Sex;

public interface SexDao {
	
	Sex findById(int id);

	List<Sex> findAllSex();
}
