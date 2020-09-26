/*
 * 	주제(Subject): Spring Security 5 - 회원 로그인 프로젝트
 * 	작성일자(Create Date): 2020-09-26
 * 	저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 	파일명(Filename): HomeController.java
 * 	내용(Description):
 * 	1. 도도(Dodo), 2020-09-26, 홈 영역 
 * 
 */

package com.web.springsecurity5.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		String password = null;
		try {
			UserDetails userDetails = (UserDetails)principal;
			
			username = userDetails.getUsername();
			password = userDetails.getPassword();
			
		}catch(Exception e) {
			e.getStackTrace();
		}

		model.addAttribute("username", username);
		model.addAttribute("password", password);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
