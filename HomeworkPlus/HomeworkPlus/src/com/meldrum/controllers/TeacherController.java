package com.meldrum.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meldrum.domain.HomeworkWrapper;
import com.meldrum.domain.shape.StandardQuestionWrapper;
import com.meldrum.utility.HomeworkCreator;

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

	model.addAttribute("homeworkWrapper", new HomeworkWrapper());

	return "teacherCreatePresetHomework";

    }

    @RequestMapping(value = "/createdHomework", method = RequestMethod.POST)
    public String viewCreatedHomework(@ModelAttribute("homeworkWrapper") HomeworkWrapper homework, BindingResult result,
	    Model model) {

	ArrayList<StandardQuestionWrapper> test1 = HomeworkCreator.createQuestion(homework.getQuestionType(),
		homework.getNumberOfQuestions());

	model.addAttribute("questions", test1);

	return "teacherCreatedHomework";

    }

}
