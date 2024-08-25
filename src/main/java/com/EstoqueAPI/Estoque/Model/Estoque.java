package com.EstoqueAPI.Estoque.Model;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    private UUID id;

    @Column(nullable = false)
    private String nomeDoProduto;

    @Column(nullable = false)
    private String tipoDoProduto;

    @Column(nullable = true)
    private String filial;

    @Column(name = "quantidade")
    private Integer quantidade = 0;

    // Mapeamento com RegistroMovimentacao
    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<RegistroMovimentacao> movimentacoes;

    // Construtores, Getters e Setters

    public Estoque() {}

    public Estoque(UUID id, String nomeDoProduto, String tipoDoProduto, Integer quantidade, String filial) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
        this.quantidade = quantidade;
        this.filial = filial;
    }

    public Estoque(EstoqueDTO estoqueDTO) {
        BeanUtils.copyProperties(estoqueDTO, this);
    }

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

    public List<RegistroMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<RegistroMovimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
