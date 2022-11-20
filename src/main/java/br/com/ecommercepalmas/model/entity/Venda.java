/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ${session.venda.lista}
 * @author Vinícius Moura
 */
@Component
@Scope("session")
@Entity
@Table(name="tb_venda")
public class Venda implements Serializable{
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    private LocalDate data = LocalDate.now();

    @Getter
    @Setter
    @OneToMany(mappedBy="venda",cascade=CascadeType.PERSIST)
    private List<ItemVenda> itens=new ArrayList();

    @Getter
    @Setter
    @ManyToOne
    private PessoaFisica cliente;
    public double total(){ return itens.stream().mapToDouble(item -> item.total()).sum();}
    public ItemVenda itemConsult(long idproduto){
       return getItens().stream().filter(item ->
                        item.getProduto().getId().equals(idproduto))
                        .findFirst().orElse(null);

    }
}
