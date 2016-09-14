package com.meldrum.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meldrum.domain.TeacherEntity;
import com.meldrum.domain.TeacherLoginForm;
import com.meldrum.service.TeacherService;
import com.meldrum.service.UserRolesService;

@Controller
public class LoginController {

    String TEACHER_ROLE = "TEACHER_ROLE";

    @Autowired
    TeacherService teacherService;

    @Autowired
    UserRolesService userRolesService;

    @RequestMapping(value = "/login/teacher", method = RequestMethod.GET)
    public String viewTeacherLoginPage(Model model) {

	model.addAttribute("teacherLoginForm", new TeacherLoginForm());

	return "teacherLoginPage";

    }

    @RequestMapping(value = "/login/teacher/authenticate", method = RequestMethod.POST)
    public String AuthenticateTeacherLogin(Model model) {

	return "teacherWelcomePage";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null) {
	    new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/login?logout";
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
	userRolesService.createUserRole(teacher.getUserName(), TEACHER_ROLE);

	return "teacherLoginPage";

    }

}