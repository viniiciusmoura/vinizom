/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.repository;



import br.com.ecommercepalmas.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Vinícius Moura
 */

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    List<PessoaFisica> findByNomeContaining(String nome);
}
