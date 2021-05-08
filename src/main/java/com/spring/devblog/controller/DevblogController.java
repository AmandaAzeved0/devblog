package com.spring.devblog.controller;

import com.spring.devblog.model.Post;

import com.spring.devblog.service.DevblogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;


//recebe as requisições dos clientes e retorn o conteudo do banco
@Controller
public class DevblogController {

    private DevblogService ds;
    public DevblogController(DevblogService ds) {
        this.ds = ds;
    }


    //listar, homepage
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        Iterable<Post> posts = ds.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    //detalhar
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id")long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = ds.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    // redireciona para o formulário de postagem
    @RequestMapping(value = "/createPost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    //criar um post
    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Preencha todos os campos obrigatórios");
            return "redirect:/createPost";
        }

        post.setData(LocalDate.now());
        ds.save(post);
        return "redirect:/posts";
    }

    //excluir post
    @RequestMapping(value="/deletePost/{id}",method = RequestMethod.GET)
    public String deletarPost(@PathVariable (value = "id") long id){
        Post post = ds.findById(id);
        ds.delete(post);
        return "redirect:/posts";
    }


    //editar post
    @RequestMapping(value = "/updatePost/{id}", method = RequestMethod.GET)
    public String getUpdateForm(){
        return "updateForm";
    }

    @RequestMapping(value = "/updatePost/{id}", method = RequestMethod.POST)
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		Post post = ds.findById(id);
		// pre populando o form
		model.addAttribute("post", post);

        ds.save(post);
        return "redirect:/posts";

	}

}

