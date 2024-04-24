package jp.ac.J.ohara.senatyan.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.Nonnull;
import jp.ac.J.ohara.senatyan.model.SubjectBook;
import jp.ac.J.ohara.senatyan.service.SubjectBookService;
 
@Controller
public class SubjectController {
    @Autowired
    private SubjectBookService subjectBookService;
    
    @GetMapping("/subjecttop/")
    public String index(Model model) {
        List<SubjectBook> subjects = subjectBookService.getSubjectList();
        model.addAttribute("subjects", subjects);
        System.out.println(subjects);
        return "subjecttop";
    }
    @GetMapping("/subjectadd/")
    public ModelAndView add(ModelAndView model) {
        model.addObject("subjectBook", new SubjectBook());
        model.setViewName("subjectadd");
        return model;
    }
    @PostMapping("/subjectadd/")
    public String add(@Validated @ModelAttribute @Nonnull SubjectBook subjectBook, RedirectAttributes redirectAttributes) {
        try {
        	subjectBookService.save(subjectBook);
            redirectAttributes.addFlashAttribute("exception", "");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("exception", e.getMessage());
        }
        return "redirect:/subjectaddcomplete/";
    }
    @GetMapping("/subjectaddcomplete/")
    public ModelAndView addcomplete(ModelAndView model) {
        model.setViewName("subjectaddcomplete");
        return model;
    }
    @GetMapping("/subjectchange/{id}/")
    public String change(@PathVariable(name = "id") Long id, Model model) {
    	SubjectBook subjectBook = subjectBookService.getOneBook(id);
        model.addAttribute("subjectBook", subjectBook);
        return "subjectchange";
    }
    @PostMapping("/subjectchange/{id}")
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute @Validated SubjectBook subjectBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "subjectchange/" + id + "/";
        }
        subjectBookService.update(subjectBook);
        return "redirect:/subjectchangecomplete/"; // 更新完了画面にリダイレクト
    }
 
    @GetMapping("/subjectchangecomplete/")
    public ModelAndView changecomplete(ModelAndView model) {
        model.setViewName("subjectchangecomplete");
        return model;
    }
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id")Long id, SubjectBook subjectBook, ModelAndView model) {
		this.subjectBookService.delete(id);
		model.setViewName("subjectdelete");
		return model;
	}
}