/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ecommercepalmas.model.repository;


import java.time.LocalDate;
import java.util.List;

import br.com.ecommercepalmas.model.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinícius Moura
 */
@Repository
public interface VendasRepository extends JpaRepository<Venda, Long> {


    Venda findByDataBetween(LocalDate datainicio, LocalDate datafim);

    @Query("from Venda as venda where venda.data=?1")
    List<Venda> findByDataVenda(LocalDate data);

}
