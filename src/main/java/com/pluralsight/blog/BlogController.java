package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    // Loads the home.html page
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        // Similar to map, but used for UI purposes
        // We use the key  in the html and the value is displayed
        modelMap.put("title", "Blog Post 1");

        List<Post> getPosts = postRepository.getAllPosts();
        modelMap.put("posts", getPosts);

        return "home";
    }
}
