package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    /**
     * This page will be triggered when we load into the default page of our website website
     * @param modelMap
     * @return Returns the home page with all the of Posts
     */
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        // Similar to map, but used for UI purposes
        // We use the key  in the html and the value is displayed
        modelMap.put("title", "Blog Post 1");

        List<Post> getPosts = postRepository.getAllPosts();
        modelMap.put("posts", getPosts);

        return "home";
    }

    /**
     * postDetails will be called when the user clicks the image of a Post.
     *      When the user clicks an image, the new page is: th:href="@{'/post/' +${entry.getId()}}"
     *      This will then trigger this method to be called.
     * @param id = PathVariable which is added to the url based on the specific POST the user clicked
     * @param modelMap - Adds the Post Info to the UI for the personal page
     * @return URL Page with the specific POST of the ID
     */
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Optional<Post> postOptional = Optional.ofNullable(postRepository.findById(id));
        modelMap.put("post", postOptional.get());
        return  "post-details";
    }
}
