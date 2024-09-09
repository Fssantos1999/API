package com.EstoqueAPI.Estoque.Repository;

import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface RegistroMovimentacaoRepository extends JpaRepository<RegistroMovimentacao,UUID> {
}
