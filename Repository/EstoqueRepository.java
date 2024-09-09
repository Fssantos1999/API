package com.EstoqueAPI.Estoque.Repository;
import com.EstoqueAPI.Estoque.Model.Estoque;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, UUID> {

    @Query(value = "SELECT * FROM estoque WHERE id = :id", nativeQuery = true)
    Optional<Estoque> findByQuery(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ESTOQUE (id, nomeDoProduto, tipoDoProduto, quantidade, filial) VALUES (:id, :nomeDoProduto, :tipoDoProduto, :quantidade, :filial)", nativeQuery = true)
    void insertEstoque(
            @Param("id") UUID id,
            @Param("nomeDoProduto") String nomeDoProduto,
            @Param("tipoDoProduto") String tipoDoProduto,
            @Param("quantidade") Integer quantidade,
            @Param("filial") String filial
    );


}
