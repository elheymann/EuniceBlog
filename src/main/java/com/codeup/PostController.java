package com.codeup;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {


    @GetMapping

    public String showAllPosts(Model model) {

        model.addAttribute("posts", DaoFactory.getPostDao().all());

        return "/index";
    }


    @GetMapping("/create")

    public String showCreatePost(Model model) {

        model.addAttribute("post", new Post());

        return "posts/create";

    }


    @PostMapping("/create")
    //public String submitPost(@ModelAttribute Post posting){

    public String submitPost(@Valid Post posting, Errors validation, Model model) {


        if (validation.hasErrors()) {

            model.addAttribute("errors", validation);

            model.addAttribute("post", posting);

            return "posts/create";

        }


        DaoFactory.getPostDao().insert(posting);

        return "redirect:/posts";


    }


    @GetMapping("/{id}")

    public String showSinglePost(Model model, @PathVariable int id) {

        model.addAttribute("post", DaoFactory.getPostDao().singlePost(id));

        return "posts/show";

    }


    @GetMapping("/{id}/edit")
    public String editPost(Model model, @PathVariable int id) {
        model.addAttribute("post", DaoFactory.getPostDao().singlePost(id));
        return "posts/edit";

    }


    @PostMapping("/{id}/edit")
    public String updatePost(@Valid Post updatedPost, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", updatedPost);
            return "posts/edit";
        }

        DaoFactory.getPostDao().updatePost(updatedPost);

        return "redirect:/posts";


    }


    @PostMapping("/{id}/delete")

    public String deletePost(@ModelAttribute Post postToDelete) {

        DaoFactory.getPostDao().deletePost(postToDelete.getId());

        return "redirect:/posts";

    }


}
