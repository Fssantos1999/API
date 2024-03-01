package com.Estoque.Gerenciamento.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Estoque.Gerenciamento.Model.Estoque.Estoque;
import com.Estoque.Gerenciamento.Repository.EstoqueRepositoriy;

/**
 * EstoqueService
 */
@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepositoriy estoqueRepository;

    public Estoque findById(Long id) {
        Optional<Estoque> estoque = this.estoqueRepository.findById(id);
        return estoque.orElseThrow(() -> new RuntimeException(
                "Product not found: " + id + ", Type: " + Estoque.class.getName()));
    }

    public Estoque addProduct(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

}
