/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_pessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String nome;

    @Getter
    @Setter
    @OneToMany(mappedBy="cliente")
    private List<Venda> vendas=new ArrayList();
}
