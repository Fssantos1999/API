package com.Estoque.Gerenciamento.Service;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;
import com.Estoque.Gerenciamento.Repository.EstoqueRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;

public class EstoqueServiceImplements implements EstoqueService {


    private final EstoqueRepositoriy estoqueRepositoriy;

    @Autowired
    public EstoqueServiceImplements(EstoqueRepositoriy estoqueRepositoriy) {
        this.estoqueRepositoriy = estoqueRepositoriy;
    }


    @Override
    public void salvarEstoque(Estoque estoque) {
        estoqueRepositoriy.save(estoque);
    }

    @Override
    public void atualizarEstoque(Estoque estoque) {
        estoqueRepositoriy.save(estoque);
    }

    @Override
    public void deletarEstoquue(Long id) {
        estoqueRepositoriy.findById(id);
    }

    public void LocalizarTodosProdutos() {
        estoqueRepositoriy.findAll();
    }

    public  void localizarProduto(Long id){
        estoqueRepositoriy.findById(id);
    }





}
