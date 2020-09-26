/*
 * 	주제(Subject): Spring Security 5 - 회원 로그인 프로젝트
 * 	작성일자(Create Date): 2020-09-26
 * 	저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 	파일명(Filename): MemberController.java
 * 	내용(Description):
 * 	1. 도도(Dodo), 2020-09-26, 회원 (로그인, 접근금지에 관한 페이지 구현) 
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
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/member/loginForm", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		
		logger.info("안녕 - 로그인 폼(Hello - Login Form");
		
		// model.addAttribute("serverTime", formattedDate );
		
		return "member/loginForm";
	}

	@RequestMapping(value = "/member/accessDenied")
	public String accessDenied(Locale locale, Model model) {

		logger.info("접근 금지 - 이동(Accessed Denied)");
		// model.addAttribute("serverTime", formattedDate );
		
		return "redirect:/member/accessDeniedView";
	}
	
	@RequestMapping(value = "/member/accessDeniedView")
	public String accessDeniedView(Locale locale, Model model) {

		logger.info("접근 금지 - 출력(Accessed Denied)");
		// model.addAttribute("serverTime", formattedDate );
		
		return "member/accessDenied";

	}
}