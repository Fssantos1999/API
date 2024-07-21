package com.Estoque.Gerenciamento.Model.EntradaProdutos;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class entradaDeProdutosRequest {

    private String dataEntrada;
    private double precoUnitario;
    private int quantidade;

    public entradaDeProdutosRequest(String dataEntrada, double precoUnitario, int quantidade) {
        this.dataEntrada = dataEntrada;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }


    public entradaDeProdutos toDoModelo(Estoque estoque) {

        LocalDateTime data = LocalDateTime.parse(dataEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new entradaDeProdutos(estoque.getId(), data, precoUnitario, quantidade);

    }

    public int quantidadeProduto(int Decrementarquantidade) {

        if (quantidade > Decrementarquantidade) {
            quantidade--;
        }
        return quantidade;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }


    public int getQuantidade() {
        return quantidade;
    }


}
