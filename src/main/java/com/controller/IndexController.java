package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/toIndex.do")
	public String toLogin(Model model) {

		return "index";
	}
}
