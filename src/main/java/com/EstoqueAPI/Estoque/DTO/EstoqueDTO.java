package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;

public class EstoqueDTO {
    private static final long serialVersionUID = 1L;
    @Id
    private UUID Produtoid;
    private String nomeDoProduto;
    private String tipoDoProduto;
    private String filial;
    @JsonDeserialize
    private Integer quantidade;
    private List<RegistroMovimentacao> movimentacoes;


    public List<RegistroMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<RegistroMovimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }




    public EstoqueDTO() {
    }

    public EstoqueDTO(Estoque estoqueEntity) {
        // Copia as propriedades da entidade Estoque para o DTO
        BeanUtils.copyProperties(estoqueEntity, this);
        this.Produtoid = estoqueEntity.getId();
    }

    public EstoqueDTO(UUID Produtoid, String nomeDoProduto, String tipoDoProduto,Integer quantidade, String filial) {
        this.Produtoid = Produtoid;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
        this.quantidade = quantidade;
        this.filial = filial;
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

    public String getFilial() {
        return filial;
    }
    public void setFilial(String filial) {
        this.filial = filial;
    }





}
