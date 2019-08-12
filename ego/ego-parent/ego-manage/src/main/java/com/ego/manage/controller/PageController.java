package com.ego.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 */

@Controller
public class PageController {
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
