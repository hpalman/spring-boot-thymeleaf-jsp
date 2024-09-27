package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Thymeleaf example
    @GetMapping("/thymeleaf")
    public String thymeleafExample(Model model) {
        model.addAttribute("message", "This is a Thymeleaf page.");
        return "thymeleafPage"; // This will map to templates/thymeleafPage.html
    }

    // JSP example
    @GetMapping("/jsp")
    public String jspExample(Model model) {
        model.addAttribute("message", "This is a JSP page.");
        return "jspPage"; // This will map to WEB-INF/jsp/jspPage.jsp
    }
}
