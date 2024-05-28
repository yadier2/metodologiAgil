package com.yadier.agilemethods.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yadier.agilemethods.models.Methodology;
import com.yadier.agilemethods.models.ResultMethod;
import com.yadier.agilemethods.services.AgileMethodologyService;

@Controller
public class AgileMethodologyController {

	private AgileMethodologyService agileMethodologyService;
	
	@Autowired
	public AgileMethodologyController(AgileMethodologyService agileMethodologyService){
		this.agileMethodologyService =agileMethodologyService;
	}
	
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		return "index";
	}
	
	
	@GetMapping("my-scrum")
	public String verPaginaScrum(Model modelo) {
		return "my-scrum";
	}
	
	@GetMapping("my-xp")
	public String verPaginaXp(Model modelo) {
		return "my-xp";
	}
	
	@GetMapping("my-kanban")
	public String verPaginaKanban(Model modelo) {
		return "my-kanban";
	}

	@GetMapping("my-lean")
	public String verPaginaLean(Model modelo) {
		return "/my-lean";
	}
	
	@GetMapping("my-crystal")
	public String verPaginaCrystal(Model modelo) {
		return "/my-crystal";
	}
	
	
	
	@GetMapping("/find-methodology")
	public String verPaginaEncontrarMetodAgil(Model modelo) {
		return "find-methodology";
	}
	
	@PostMapping("/choose-methodology")
	public ModelAndView chooseMethodology(@Valid @ModelAttribute("methodology") Methodology methodology, BindingResult result) {
		ModelAndView model = new ModelAndView();
		 String errors = methodology.validateFields();
	     if (!errors.isEmpty()) {
			model.addObject("error", 1);
			model.setViewName("find-methodology");
        }else {
		ResultMethod resultMethod= agileMethodologyService.chooseMethodology(methodology);
		model.addObject("resultMethod", resultMethod);
		model.setViewName("results");
        }
		return model;
	}

	
	

}