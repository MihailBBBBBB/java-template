package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    ModelAndView index() {
        ArrayList<Student> students = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("date", new Date().toString());
        return modelAndView;
    }

    @GetMapping(value = "/about")
    ModelAndView about(@RequestParam HashMap<String, String> queryStringParams) {
            ModelAndView modelAndView = new ModelAndView("about");

            String id = queryStringParams.get("id");
            String title = queryStringParams.get("title");
            String description = queryStringParams.get("description");

            // turpinat veidot html formu

            return modelAndView;
    }


    // Metode priekš koda testēšanas
    @GetMapping(value = "/test")
    public ModelAndView testAction() {
        ModelAndView modelAndView = new ModelAndView("test");

        
        modelAndView.addObject("output1", 1);
     

        return modelAndView;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView register(HttpServletRequest request, @ModelAttribute("student") Student student) {
        Student newStudent = new Student();
        ModelAndView modelAndView = new ModelAndView("registration/registration-page");
        List<String> groups = new ArrayList<>(List.of("DP2-1", "DP2-2", "DP2-3", "DP2-4"));
        modelAndView.addObject("student", newStudent);
        modelAndView.addObject("groups", groups);
        System.out.println(student);
        return modelAndView;
    }

}
