package com.jin.controller;

import com.jin.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {

	@RequestMapping("/")
	public String home() {
		return "demo/home";
	}

	@RequestMapping("/openWork/{work}")
	public String openWork(@PathVariable("work") String work) {
		return "demo/" + work;
	}

	@RequestMapping({"/success","/info"})
	public String success() {
		return "demo/success";
	}

}