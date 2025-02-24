package io.github.curso.blogapi.controller;

import io.github.curso.blogapi.model.Post;
import io.github.curso.blogapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    PostService service;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetalhes(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postsDetalhes");
        Post post = service.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/novoPost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value = "/novoPost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagemErro", "Verifique se os campos obrigatórios estão preenchidos!");
            return "redirect:/novoPost";
        } else {
            post.setData(LocalDate.now());
            service.save(post);
            attributes.addFlashAttribute("mensagem", "Novo post cadastrado com sucesso!");
            return "redirect:/posts";
        }
    }


}
