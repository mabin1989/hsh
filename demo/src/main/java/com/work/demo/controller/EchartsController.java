package com.work.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/echartscontroller")
public class EchartsController {
	
	
	@RequestMapping(value="/bar")
	@ResponseBody
	public List bar() {
		List list=new ArrayList();
		list.add(Math.random()*100);
		list.add(Math.random()*100);
		list.add(Math.random()*100);
		list.add(Math.random()*100);
		list.add(Math.random()*100);
		list.add(Math.random()*100);
		return list;
	}
}
