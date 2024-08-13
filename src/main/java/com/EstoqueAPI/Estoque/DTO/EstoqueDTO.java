package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.Estoque;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class EstoqueDTO {
    private static final long serialVersionUID = 1L;
    @Id
    private UUID Produtoid;
    private String nomeDoProduto;
    private String tipoDoProduto;
    @JsonDeserialize
    private Integer quantidade;

    public EstoqueDTO() {
    }

    public EstoqueDTO(Estoque estoqueEntity) {
        // Copia as propriedades da entidade Estoque para o DTO
        BeanUtils.copyProperties(estoqueEntity, this);
        this.Produtoid = estoqueEntity.getId();
    }

    public EstoqueDTO(UUID Produtoid, String nomeDoProduto, String tipoDoProduto,Integer quantidade) {
        this.Produtoid = Produtoid;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;

    }

}
