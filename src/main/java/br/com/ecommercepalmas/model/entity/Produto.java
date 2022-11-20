/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name="tb_produto")
public class Produto {

    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String descricao;
    @Getter
    @Setter
    @Min(1)
    private double valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
