/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name = "tb_pessoajuridica")
public class PessoaJuridica extends Pessoa{
    @NotBlank
    @CNPJ
    private String cnpj;
        

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
