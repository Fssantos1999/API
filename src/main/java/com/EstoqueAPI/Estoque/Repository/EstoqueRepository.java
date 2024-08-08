package com.EstoqueAPI.Estoque.Repository;


import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,UUID > {

}
