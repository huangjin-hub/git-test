package com.jin.controller;

import com.jin.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.jin.entity.Dept;
import com.jin.service.DeptService;

import java.util.List;

@RestController
public class DeptController extends BaseController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept){
		return deptService.addDept(dept);
	}

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = deptService.queryById(id);
		if (dept==null){
			throw new RuntimeException("Fail");
		}
		return dept;
	}

	@GetMapping("/dept/list")
	public List<Dept> queryAll(){
		return deptService.queryAll();
	}

	@GetMapping("/dept/discovery")
	public Object discovery(){
		List<String> services = discoveryClient.getServices();
		System.out.println("discovery=>services:"+services);
		List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PRODUCT-8081");
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getHost()+"\t"
								+instance.getPort()+"\t"
								+instance.getUri()+"\t"
								+instance.getServiceId()
			);
		}
		return this.discoveryClient;
	}
}