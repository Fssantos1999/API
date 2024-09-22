package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RegistroMovimentacaoDTO {

    private UUID idTransacao;
    private Integer quantidadeRecebida;
    private String regiaoSaida;
    private String regiaoEntrada;
    private LocalDateTime dataEntrada;
    private UUID estoqueId;

//constructor
    public RegistroMovimentacaoDTO() {}


    public RegistroMovimentacaoDTO(UUID idTransacao, Integer quantidadeRecebida, String regiaoSaida,
                                   String regiaoEntrada, LocalDateTime dataEntrada,UUID estoqueId) {
        this.idTransacao = idTransacao;
        this.quantidadeRecebida = quantidadeRecebida;
        this.regiaoSaida = regiaoSaida;
        this.regiaoEntrada = regiaoEntrada;
        this.dataEntrada = dataEntrada;
        this.estoqueId = estoqueId;

    }


    public UUID getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Integer getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(Integer quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }

    public String getRegiaoSaida() {
        return regiaoSaida;
    }

    public void setRegiaoSaida(String regiaoSaida) {
        this.regiaoSaida = regiaoSaida;
    }

    public String getRegiaoEntrada() {
        return regiaoEntrada;
    }

    public void setRegiaoEntrada(String regiaoEntrada) {
        this.regiaoEntrada = regiaoEntrada;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public UUID getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(UUID estoqueId) {
        this.estoqueId = estoqueId;
    }
}
