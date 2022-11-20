/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.repository;


import br.com.ecommercepalmas.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vinícius Moura
 */

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
    
}
