package br.com.ecommercepalmas.controller;

import br.com.ecommercepalmas.model.entity.ItemVenda;
import br.com.ecommercepalmas.model.entity.Venda;
import br.com.ecommercepalmas.model.repository.PessoaFisicaRepository;
import br.com.ecommercepalmas.model.repository.ProdutosRepository;
import br.com.ecommercepalmas.model.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Scope("request")
@Transactional
@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    ProdutosRepository produto;

    @Autowired
    Venda venda;
    @Autowired
    PessoaFisicaRepository pessoaFisica;

    @GetMapping("/")
    public ModelAndView cart(ModelMap model){
        model.addAttribute("clientes",pessoaFisica.findAll());
        return new ModelAndView("/carrinho/cart");
    }

    @PostMapping("/additem")
    public ModelAndView addcart(@Valid ItemVenda itemVenda, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())
            attributes.addFlashAttribute("erro","Adicione uma quantidade");
        else {
            var item = venda.itemConsult(itemVenda.getProduto().getId());
            if (item == null) {
                itemVenda.setProduto(produto.findById(itemVenda.getProduto().getId()).get());
                itemVenda.setQtd(itemVenda.getQtd());
                itemVenda.setVenda(venda);
                venda.getItens().add(itemVenda);
                attributes.addFlashAttribute("success",itemVenda.getProduto().getDescricao() + " adicionado ao carrinho");
            } else {
                item.qtdMais(itemVenda.getQtd());
                attributes.addFlashAttribute("success", "Foi adicionado mais " + itemVenda.getQtd() +"x"+item.getProduto().getDescricao());
            }
        }
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id, RedirectAttributes attributes){
        venda.getItens().remove(venda.itemConsult(id));
        attributes.addFlashAttribute("success", "Produto removido do carrinho!");
        return new ModelAndView("redirect:/cart/");
    }

    @GetMapping("/updateaddqtd/{id}")
    public ModelAndView updateaddquantidade(@PathVariable("id") Long id){
        venda.itemConsult(id).addQtd();
        return new ModelAndView("redirect:/cart/");
    }
    @GetMapping("/updatesubqtd/{id}")
    public ModelAndView updatesubquantidade(@PathVariable("id") Long id){
        venda.itemConsult(id).removeQtd();
        return new ModelAndView("redirect:/cart/");
    }












}
