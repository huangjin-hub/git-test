package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jin.entity.Dept;
import com.jin.dao.DeptMapper;

@Transactional
@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;

	public DeptMapper getDeptMapper() {
		return deptMapper;
	}

}