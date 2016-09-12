package com.meldrum.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class MainController{
	
	@RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public String viewStudentHomePage(Model model){
		
		
		
		return "studentFrontPage";
		
	}
	
	@RequestMapping(value = "/teacherWelcome", method=RequestMethod.GET)
	public String viewTeacherHomePage(Model model){
		
		
		
		return "teacherWelcomePage";
		
	}
	
	@RequestMapping(value = "/parentWelcome", method=RequestMethod.GET)
	public String viewParentHomePage(Model model){
		
		
		
		return "parentsWelcomePage";
		
	}


}
