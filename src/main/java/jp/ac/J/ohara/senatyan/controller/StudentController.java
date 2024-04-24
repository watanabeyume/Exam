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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.Nonnull;
import jp.ac.J.ohara.senatyan.model.StudentBook;
import jp.ac.J.ohara.senatyan.service.StudentBookService;
 
@Controller
public class StudentController {
    @Autowired
    private StudentBookService studentBookService;
    @GetMapping("/studenttop/")
    public String index(Model model) {
        List<StudentBook> students = studentBookService.getStudentList();
        model.addAttribute("students", students);
        System.out.println(students);
        return "studenttop";
    }
    @PostMapping("/studenttop/")
    public String handleListActions(
            @RequestParam(name = "entYear", required = false) Integer entYear,
            @RequestParam(name = "classNum", required = false) String classNum,
            @RequestParam(name = "isAttend", required = false) Boolean isAttend,
            Model model) {
        // 検索操作の場合
    	model.addAttribute("students", studentBookService.filterStudents(entYear, classNum, isAttend));
//        List<StudentBook> students = studentBookService.filterStudents(entYear, classNum, isAttend);
//        System.out.println("検索結果: " + students);
//        model.addAttribute("searchedStudents", students);
        return "studenttop"; // 検索結果のテンプレート名を返す
    }
    @GetMapping("/studentadd/")
    public ModelAndView add(ModelAndView model) {
        model.addObject("studentBook", new StudentBook());
        model.setViewName("studentadd");
        return model;
    }
    @PostMapping("/studentadd/")
    public String add(@Validated @ModelAttribute @Nonnull StudentBook studentBook, RedirectAttributes redirectAttributes) {
        try {
            studentBookService.save(studentBook);
            redirectAttributes.addFlashAttribute("exception", "");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("exception", e.getMessage());
        }
        return "redirect:/studentaddcomplete/";
    }
    @GetMapping("/studentaddcomplete/")
    public ModelAndView addcomplete(ModelAndView model) {
        model.setViewName("studentaddcomplete");
        return model;
    }
    @GetMapping("/studentchange/{id}/")
    public String change(@PathVariable(name = "id") Long id, Model model) {
        StudentBook studentBook = studentBookService.getOneBook(id);
        model.addAttribute("studentBook", studentBook);
        return "studentchange";
    }
    @PostMapping("/studentchange/{id}/")
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute @Validated StudentBook studentBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "studentchange/{id}/";
        }
        studentBookService.update(studentBook);
        return "redirect:/studentchangecomplete/"; // 更新完了画面にリダイレクト
    }
 
 
    
    @GetMapping("/studentchangecomplete/")
    public ModelAndView changecomplete(ModelAndView model) {
        model.setViewName("studentchangecomplete");
        return model;
    }
}
