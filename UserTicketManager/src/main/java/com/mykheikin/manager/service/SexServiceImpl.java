package com.mykheikin.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.manager.dao.SexDao;
import com.mykheikin.manager.model.Sex;

@Service("sexService")
@Transactional
public class SexServiceImpl implements SexService {

	@Autowired
	private SexDao sexDao;
	
	@Override
	public List<Sex> findAllSex() {
		return sexDao.findAllSex();
	}

	@Override
	public Sex findById(int id) {
		return sexDao.findById(id);
	}
}
