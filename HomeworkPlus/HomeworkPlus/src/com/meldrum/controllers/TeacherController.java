package com.meldrum.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meldrum.domain.HomeworkWrapper;
import com.meldrum.utility.HomeworkCreator;
import com.sun.org.apache.xml.internal.security.utils.Base64;

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

	BufferedImage test1 = HomeworkCreator.createImage(homework.getQuestionType(), homework.getNumberOfQuestions());
	try {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(test1, "png", baos);
	    baos.flush();
	    byte[] imageInByte = baos.toByteArray();
	    baos.close();

	    String encodedImage = Base64.encode(imageInByte);

	    model.addAttribute("image", encodedImage);

	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}

	// model.addAttribute("questionImage", test1);

	return "teacherCreatedHomework";

    }

}
