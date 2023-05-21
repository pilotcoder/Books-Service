package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("programmingSkills")
        public List<String> skills() {
            return Arrays.asList("JAVA", "PHP", "C#", "Kotlin", "Python");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("rower", "lotnictwo", "narty", "pływanie", "spanie");
    }


    @GetMapping(path = "/studentform")
    String showForm(Model model){
        model.addAttribute("student", new Student());

        return "student/form";
    }

    @PostMapping(path = "/studentform")
    @ResponseBody
    String processAddForm(Student student){
        return student.toString();
    }



}
