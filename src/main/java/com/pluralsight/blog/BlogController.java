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
        // We use the key  in the html and the value is displayed
        modelMap.put("title", "Blog Post 1");
        return "home";
    }
}
