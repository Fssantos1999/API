package com.Estoque.Gerenciamento.Model.EntradaProdutos;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EntradaProdutos")
public class entradaDeProdutos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataDaEntrada;
    private double precoUnitario;
    private int quantidade;
    @ManyToOne
    private Estoque estoque;


    public entradaDeProdutos(Long id, LocalDateTime dataDaEntrada, double precoUnitario, int quantidade) {
        this.id = id;
        this.dataDaEntrada = dataDaEntrada;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }


    public Long getId() {
        return id;
    }

    public LocalDateTime getDataDaEntrada() {
        return dataDaEntrada;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDataDaEntrada(LocalDateTime dataDaEntrada) {
        this.dataDaEntrada = dataDaEntrada;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
