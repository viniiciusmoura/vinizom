/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name = "tb_pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable{

    @Getter
    @Setter
    @CPF
    private String cpf;
}
