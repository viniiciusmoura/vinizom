/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.ecommercepalmas.model.entity.Cliente;
import br.com.ecommercepalmas.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Vinícius Moura
 */
@Controller
@Transactional
@RequestMapping("cliente")
public class ClienteController {
    
    @Autowired
    PessoaFisicaRepository repositoryPF;
    
    
    @GetMapping("/form")
    public ModelAndView form(Cliente pessoasFisica){ return new ModelAndView("/clientes/form"); }
    
    @PostMapping("/save")
    public ModelAndView save(@Valid Cliente pessoafisica, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())
            return form(pessoafisica);
        repositoryPF.save(pessoafisica);
        attributes.addFlashAttribute("success",pessoafisica.getNome() + " cadastrado com sucesso!");
        return new ModelAndView("redirect:/cliente/form");
    }
    
    @GetMapping("/list")
    public ModelAndView list(ModelMap model,@RequestParam(required = false) String nome){

        System.out.println(nome==null || nome.length()==0 ? 0 : 1);
        model.addAttribute("pessoaFisica",nome==null || nome.length()==0 ? repositoryPF.findAll() : repositoryPF.findByNomeContaining(nome));
        return new ModelAndView("/clientes/list", model);
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", repositoryPF.findById(id).get());
        return new ModelAndView("/clientes/form", model);
    }
    
    @PostMapping("/update")
    public ModelAndView update(@Valid Cliente pessoafisica, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors())
            return form(pessoafisica);
        repositoryPF.save(pessoafisica);
        attributes.addFlashAttribute("success",pessoafisica.getNome() + " atualizado com sucesso!");
        return new ModelAndView("redirect:/cliente/list");
    }
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id,RedirectAttributes attributes){
        repositoryPF.deleteById(id);
        attributes.addFlashAttribute("success","Cliente removido!");
        return new ModelAndView("redirect:/cliente/list");
    }
    
    
}
