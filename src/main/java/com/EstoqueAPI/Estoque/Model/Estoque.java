package com.EstoqueAPI.Estoque.Model;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import jakarta.persistence.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String nomeDoProduto;

    @NotNull
    @Column(nullable = false)
    private String tipoDoProduto;

    public Estoque() {
    }


    public Estoque(UUID id, String nomeDoProduto, String tipoDoProduto) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.tipoDoProduto = tipoDoProduto;
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
}
