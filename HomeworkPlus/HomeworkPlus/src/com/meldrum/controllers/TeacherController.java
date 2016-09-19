package com.meldrum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {

    @RequestMapping(value = "/createClass", method = RequestMethod.GET)
    public String viewCreateClassPage(Model model) {

	return "teacherCreateClass";

    }

    @RequestMapping(value = "/viewClasses", method = RequestMethod.GET)
    public String viewClassesPage(Model model) {

	return "teacherViewClasses";

    }

    @RequestMapping(value = "/createPresetHomework", method = RequestMethod.GET)
    public String viewCreatePresetHomeworkPage(Model model) {

	return "teacherCreatePresetHomework";

    }

}
