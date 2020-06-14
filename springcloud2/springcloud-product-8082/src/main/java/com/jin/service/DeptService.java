package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jin.entity.Dept;
import com.jin.dao.DeptMapper;

import java.util.List;

public interface DeptService {

	public boolean addDept(Dept dept);

	public Dept queryById(Long id);

	public List<Dept> queryAll();

}