package com.Estoque.Gerenciamento.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;

@Repository
public interface EstoqueRepositoriy extends JpaRepository <Estoque,Long> {
//Optional <Estoque> findByDistribuidora(String distribuidora);
    
}   