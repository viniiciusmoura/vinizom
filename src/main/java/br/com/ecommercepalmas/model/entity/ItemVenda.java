/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_itemvenda")
public class ItemVenda implements Serializable{
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @Min(1)
    private double qtd;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_venda")
    private Venda venda;

    public void qtdMais(double qtdm){
        this.qtd+=qtdm;
    }
    public double total(){
        return produto.getValor() * this.qtd;
    }
    
    public void addQtd(){
        this.qtd++;
    }
    public void removeQtd(){if(this.qtd!=1) this.qtd--;}
}
