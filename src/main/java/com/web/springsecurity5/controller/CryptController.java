/*
 * 	주제(Subject): Spring Security 5 - 회원 로그인 프로젝트
 * 	작성일자(Create Date): 2020-09-26
 * 	저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 	파일명(Filename): CryptController.java
 * 	내용(Description):
 * 	1. 도도(Dodo), 2020-09-26, 암호화에 대한 내용 
 * 
 */

package com.web.springsecurity5.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class CryptController {

	private static final Logger logger = LoggerFactory.getLogger(CryptController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/encode-password", method = RequestMethod.GET)
	public String bcrypt(Locale locale, Model model, HttpServletRequest req) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getServletContext());
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

        String password = req.getParameter("password");
        String encode = passwordEncoder.encode(password);

        model.addAttribute("encode", encode);
        System.out.println(encode);
        
		return "home";
	}
	
}
