package com.work.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/test")
	public String test(Model model) {
		List<Map> userList = new ArrayList();
		Map m = new HashMap();
		m.put("name", "张三");
		m.put("sex", "男");
		m.put("age", "1");
		Map m1 = new HashMap();
		m1.put("name", "李四");
		m1.put("sex", "女");
		m1.put("age", "2");
		userList.add(m);
		userList.add(m1);
		model.addAttribute("userList", userList);
		return "/tem";
	}
}
