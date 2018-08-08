package com.netcracker.edu.smartgreenhouse.server.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView getIndexPage() {
        return new ModelAndView("layout");
    }
}
