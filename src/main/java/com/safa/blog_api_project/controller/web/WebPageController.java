package com.safa.blog_api_project.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    @GetMapping("/home")
    public String getHomePage() {
        return "index";
    }
}
