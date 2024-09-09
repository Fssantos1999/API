package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.Estoque;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EstoqueDTO {

    private UUID id;
    private String nomeDoProduto;
    private String tipoDoProduto;
    private String filial;
    private Integer quantidade;
    private List<RegistroMovimentacaoDTO> movimentacoes;

    // Construtor padrão
    public EstoqueDTO() {}

    // Construtor com parâmetros
    public EstoqueDTO(UUID id, String nomeDoProduto, String tipoDoProduto, Integer quantidade, String filial, List<RegistroMovimentacaoDTO> movimentacoes) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
        this.quantidade = quantidade;
        this.filial = filial;
        this.movimentacoes = movimentacoes;
    }

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public List<RegistroMovimentacaoDTO> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<RegistroMovimentacaoDTO> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
