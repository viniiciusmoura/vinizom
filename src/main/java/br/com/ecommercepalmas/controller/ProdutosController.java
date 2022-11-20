/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.controller;


import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.ecommercepalmas.model.entity.ItemVenda;
import br.com.ecommercepalmas.model.entity.Produto;
import br.com.ecommercepalmas.model.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Vinícius Moura
 */
@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutosRepository repository;
    
    
    
    @GetMapping("/list")
    public ModelAndView list(ItemVenda itemVenda, ModelMap model){
        model.addAttribute("produtos", repository.findAll());
        return new ModelAndView("produtos/list", model);
    }
    
    @GetMapping("/form")
    public ModelAndView form(Produto produto){
        return new ModelAndView("produtos/form");
    }
    
    @PostMapping("/save")
    public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors())
            return form(produto);
        repository.save(produto);
        attributes.addFlashAttribute("success",produto.getDescricao() + " cadastrado com sucesso!");
        return new ModelAndView("redirect:/produtos/form");
    }
    
    
}
