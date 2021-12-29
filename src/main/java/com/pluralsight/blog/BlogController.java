package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    // Can autowire this as well but not part of project
    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

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

    // This RequestMapping will format to the specific image we click
    // {id} => Means its a path variable
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Optional<Post> postOptional = Optional.ofNullable(postRepository.findById(id));
        modelMap.put("post", postOptional.get());
        return  "post-details";
    }
}
