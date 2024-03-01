package com.Estoque.Gerenciamento.Model.EntradaProdutos;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;

public class EntradaRequest {

   // private Double precoUnitario;
    @Column(nullable = false)
    private Integer quantidade;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String dataEntrada;

}
