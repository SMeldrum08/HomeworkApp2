package com.meldrum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meldrum.domain.TeacherEntity;
import com.meldrum.service.TeacherService;

@Controller
public class LoginController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/login/teacher", method = RequestMethod.GET)
    public String viewStudentHomePage(Model model) {

	return "teacherLoginPage";

    }

    @RequestMapping(value = "/login/teacherRegister", method = RequestMethod.GET)
    public String viewTeacherHomePage(@ModelAttribute("teacherEntity") TeacherEntity teacher, BindingResult result,
	    ModelMap model) {

	model.addAttribute("teacherEntity", new TeacherEntity());

	return "teacherRegister";

    }

    @RequestMapping(value = "/login/teacherRegister", method = RequestMethod.POST)
    public String saveTeacherPage(@ModelAttribute("teacherEntity") TeacherEntity teacher, BindingResult result,
	    ModelMap model) {

	teacherService.createTeacher(teacher);

	return "teacherLoginPage";

    }

}