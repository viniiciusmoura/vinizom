package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String cep;

    @Getter
    @Setter
    @NotBlank
    private String numero;

    @Getter
    @Setter
    @NotBlank
    private String bairro;

    @Getter
    @Setter
    @NotBlank
    private String cidadde;

    @Getter
    @Setter
    @NotBlank
    private String estado;

    @Getter
    @Setter
    @NotBlank
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
