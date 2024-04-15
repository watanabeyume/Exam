package jp.ac.J.ohara.senatyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.J.ohara.senatyan.model.StudentBook;
import jp.ac.J.ohara.senatyan.service.StudentBookService;

@Controller
public class StudentContoller {
	@Autowired
	private StudentBookService studentBookService;
	@GetMapping("/studenttop/")
	public String index(Model model) {
		List<StudentBook> students = studentBookService.getStudentList();
		model.addAttribute("students",students);
		return "studenttop";
	}
	@GetMapping("/studentadd/")
  	public ModelAndView add(StudentBook studentBook, ModelAndView model) {
  		model.addObject("studentBook", studentBook);
  		model.setViewName("studentadd");
  		return model;
  	}
	@PostMapping("/studentadd/")
  	public String add(@Validated @ModelAttribute @NonNull StudentBook studentBook, RedirectAttributes result,
  			ModelAndView model,
  			RedirectAttributes redirectAttributes) {
  		try {
  			this.studentBookService.save(studentBook);
  			redirectAttributes.addFlashAttribute("exception", "");
   
  		} catch (Exception e) {
  			redirectAttributes.addFlashAttribute("exception", e.getMessage());
  		}
  		return "redirect:/studenttop/";
  }
}
