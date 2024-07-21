package com.Estoque.Gerenciamento.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Estoque.Gerenciamento.Model.Estoque.Estoque;
import com.Estoque.Gerenciamento.Repository.EstoqueRepositoriy;

/**
 * EstoqueService
 */

public interface EstoqueService {

    void salvarEstoque(Estoque estoque);

    void atualizarEstoque(Estoque estoque);

    void deletarEstoquue(Long id);

}
