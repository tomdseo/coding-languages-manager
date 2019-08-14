package com.tommy.languages.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tommy.languages.models.LanguageModel;
import com.tommy.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	//2 Redirects
	@RequestMapping("")
	public String redirect1() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/")
	public String redirect2() {
		return "redirect:/languages";
	}
	
	//Home Page
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") LanguageModel language, BindingResult result, Model model) {
		List<LanguageModel> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	//Input Language Form
    @RequestMapping(value="/create_language", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    //Look Up Specific Language
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	LanguageModel language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "languages/show.jsp";
    }
    
    //Redirect to Home Page
    @RequestMapping("/dashboard")
    public String dashboard() {
    	return "redirect:/languages";
    }
    
    //Part 1 for Edit (render user to edit page)
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        LanguageModel language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    //Part 2 for Edit (actually saves the change in the database)
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    //Delete Specific Language
    @RequestMapping(value="/languages/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }
    
}
