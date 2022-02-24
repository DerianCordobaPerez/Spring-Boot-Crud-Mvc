package com.pplam.crudmvcnotes.controllers;

import com.pplam.crudmvcnotes.entities.Post;
import com.pplam.crudmvcnotes.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(path = "/posts")
    public String index(Model model) {
        model.addAttribute("posts", this.postRepository.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("post", this.postRepository.findById(id));
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String store(@RequestParam String title, @RequestParam String body, Model model) {
        Post post = new Post(title, body);
        this.postRepository.save(post);
        model.addAttribute("posts", this.postRepository.findAll());
        return "redirect:/posts/";
    }

    @GetMapping(path = "/posts/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("post", this.postRepository.findById(id));
        return "posts/edit";
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @PostMapping(path = "/posts/{id}/edit")
    public String update(@RequestParam String title, @RequestParam String body, @PathVariable Long id, Model model) {
        Post post = this.postRepository.findById(id).get();
        post.setTitle(title);
        post.setBody(body);
        this.postRepository.save(post);
        model.addAttribute("posts", this.postRepository.findAll());
        return "redirect:/posts/";
    }

    @GetMapping(path = "/posts/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        this.postRepository.deleteById(id);
        model.addAttribute("posts", this.postRepository.findAll());
        return "redirect:/posts/";
    }
}
