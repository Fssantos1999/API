package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.Estoque;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class EstoqueDTO {

    private UUID Produtoid;
    private String nomeDoProduto;
    private String tipoDoProduto;

    public EstoqueDTO() {
    }

    public EstoqueDTO(Estoque estoqueEntity) {
        // Copia as propriedades da entidade Estoque para o DTO
        BeanUtils.copyProperties(estoqueEntity, this);
        this.Produtoid = estoqueEntity.getId();
    }

    public EstoqueDTO(UUID Produtoid, String nomeDoProduto, String tipoDoProduto) {
        this.Produtoid = Produtoid;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
    }

    public UUID getProdutoid() {
        return Produtoid;
    }

    public void setProdutoid(UUID produtoid) {
        this.Produtoid = produtoid;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getTipoDoProduto() {
        return tipoDoProduto;
    }

    public void setTipoDoProduto(String tipoDoProduto) {
        this.tipoDoProduto = tipoDoProduto;
    }
}
