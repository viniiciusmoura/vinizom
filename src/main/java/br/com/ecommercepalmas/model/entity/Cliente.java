/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Vinícius Moura
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa implements Serializable{

    @Getter
    @Setter
    @CPF
    @NotBlank
    private String cpf;

    @Getter
    @Setter
    @NotBlank
    private String telefone;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private  Usuario usuario;
}
