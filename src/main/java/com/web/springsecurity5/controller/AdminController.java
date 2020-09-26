/*
 * 	주제(Subject): Spring Security 5 - 회원 로그인 프로젝트
 * 	작성일자(Create Date): 2020-09-26
 * 	저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 	파일명(Filename): AdminController.java
 * 	내용(Description):
 * 	1. 도도(Dodo), 2020-09-26, 관리자 페이지에 대한 내용 
 * 
 */
package com.web.springsecurity5.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome - 관리자 페이지(Admin Home)!");
		
		return "admin/home";
	}
}
