package com.pfe.myschool.controller;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class GenPwdController {
	
	@RequestMapping("/genPwd1")
    String genPwd1() {
		String pwd = RandomStringUtils.randomAlphabetic(8);
		String pwd1 = RandomStringUtils.randomAlphanumeric(8);
	     return "Alphabetic : "+ pwd + "    Alphanumeric : "+pwd1;
		
    }
}
