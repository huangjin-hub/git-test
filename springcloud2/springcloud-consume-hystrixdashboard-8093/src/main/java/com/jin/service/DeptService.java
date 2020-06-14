package com.jin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jin.entity.Dept;
import com.jin.dao.DeptMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@FeignClient("SPRINGCLOUD-PRODUCT")
public interface DeptService {

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept);

	@GetMapping("/dept/get/{id}")
	public Dept queryById(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	public List<Dept> queryAll();


}