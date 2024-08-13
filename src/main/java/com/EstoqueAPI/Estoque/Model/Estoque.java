package com.EstoqueAPI.Estoque.Model;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable = false)
    private String nomeDoProduto;
    @Column(name = "quantidade")
    @JsonDeserialize
    private Integer quantidade = 0;
    @Column(nullable = false)
    private String tipoDoProduto;

    public Estoque() {
    }
    public Estoque(UUID id, String nomeDoProduto, String tipoDoProduto,Integer quantidade) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
        this.quantidade = quantidade;
    }

    // Construtor para transformar DTO em entidade
    public Estoque(EstoqueDTO estoqueDTO) {
        BeanUtils.copyProperties(estoqueDTO, this);
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;

    }



}
