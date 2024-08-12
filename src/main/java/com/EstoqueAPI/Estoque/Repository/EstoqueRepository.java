package com.EstoqueAPI.Estoque.Repository;


import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<Estoque, UUID> {

    @Query(value = "SELECT * FROM estoque WHERE id = :id", nativeQuery = true)
    Optional<Estoque> findByIdNativo(@Param("id") UUID id);
}
