/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.controller;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import br.com.ecommercepalmas.model.entity.Cliente;
import br.com.ecommercepalmas.model.entity.Venda;
import br.com.ecommercepalmas.model.repository.PessoaFisicaRepository;
import br.com.ecommercepalmas.model.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

/**
 *
 * @author Vinícius Moura
 */

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendasController {

    
    @Autowired
    VendasRepository repositoryVend;
    
    @Autowired
    Venda venda;
    
    @Autowired
    PessoaFisicaRepository pf;
    
    @GetMapping("/carrinho")
    public ModelAndView form(ModelMap model){
        model.addAttribute("clientes",pf.findAll());
        return new ModelAndView("/vendas/carrinho");
    }
    
    
    @PostMapping("/addcliente")
    public String addcliente(Cliente pessoaFisica){
        venda.setCliente(pf.findById(pessoaFisica.getId()).get());
        return "redirect:/vendas/carrinho";
    }

    
    
    @GetMapping("/finalizarcompra")
    public String finalizarcompra(final HttpServletRequest request){
        repositoryVend.save(venda);
        request.getSession().invalidate();
        return "redirect:/vendas/";
    }
    
    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(ModelMap model,@PathVariable("id") Long id){
        model.addAttribute("listadeitens",repositoryVend.findById(id).get());
        return new ModelAndView("/vendas/detalhes");
    }

    @GetMapping("/teste")
    public String testeData(){
        LocalDate dataInicio = LocalDate.now();
        LocalDate dataFim = LocalDate.now();
        System.out.println("\n\n\n ==>"+repositoryVend.findByDataBetween(dataInicio.minusDays(3),dataFim));
        return "redirect:/vendas/carrinho";
    };

    @GetMapping("/findvenda/{data}")
    public ModelAndView findyData(ModelMap model,@PathVariable("data") String data){
        model.addAttribute("vendas",repositoryVend.findByDataVenda(LocalDate.parse(data)));
        return new ModelAndView("/vendas/list");
    }

    
    @GetMapping("/")
    public ModelAndView vendasrealizadas(ModelMap model){
        model.addAttribute("vendas",repositoryVend.findAll());
        return new ModelAndView("/vendas/list");
    }
    
    
    
    
}
