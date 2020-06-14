package com.jin.controller;

import com.jin.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jin.entity.Dept;
import com.jin.service.DeptService;

import java.util.List;

@RestController
public class DeptController extends BaseController {

	@Autowired
	private DeptService deptService;

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept){
		return deptService.addDept(dept);
	}

	@GetMapping("/dept/get/{id}")
	public Dept getDeptById(@PathVariable("id")Long id){
		System.out.println("---------------------------"+id);
		return deptService.queryById(id);
	}

	@GetMapping("/dept/list")
	public List<Dept> queryAll(){
		return deptService.queryAll();
	}
}