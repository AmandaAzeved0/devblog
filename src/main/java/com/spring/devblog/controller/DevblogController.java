package com.spring.devblog.controller;

import com.spring.devblog.model.Post;
import com.spring.devblog.service.DevblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//recebe as requisições dos clientes e retorn o conteudo do banco
@Controller
public class DevblogController {

    @Autowired
    DevblogService devblogService;


    //lista de posts, homepage
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = devblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    //detalhes de um post específico
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id")long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = devblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    //metodo para acessar a pagina de formulario de novo post
    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    // salvar novo post
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    // @valid para verificar se o atributos poram preenchidos de forma como prevista no model
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Preencha todos os campos obrigatórios");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        devblogService.save(post);
        return "redirect:/posts";
    }
//
//    //excluir post
//
//    //editar post
//    @RequestMapping(value = "/postDetails/{id}", method = RequestMethod.GET)




}

