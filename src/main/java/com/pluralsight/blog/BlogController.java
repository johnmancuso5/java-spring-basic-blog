package com.pluralsight.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    // Loads the home.html page
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        // Similar to map, but used for UI purposes
        modelMap.put("title", "Blog Post 1");
        return "home";
    }
}
