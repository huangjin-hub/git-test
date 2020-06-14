package com.jin.controller;

import com.jin.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.jin.entity.Dept;
import com.jin.service.DeptService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController extends BaseController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept){
		return restTemplate.getForEntity("http://SPRINGCLOUD-PRODUCT/dept/add", boolean.class, dept).getBody();
	}

	@GetMapping("/dept/get/{id}")
	public Dept getDeptById(@PathVariable Long id){
		System.out.println("---------------------------"+id);
		return restTemplate.getForEntity("http://SPRINGCLOUD-PRODUCT/dept/get/"+id, Dept.class).getBody();
	}

	@GetMapping("/dept/list")
	public List<Dept> queryAll(){
		return restTemplate.getForEntity("http://SPRINGCLOUD-PRODUCT/dept/list", List.class).getBody();
	}
}