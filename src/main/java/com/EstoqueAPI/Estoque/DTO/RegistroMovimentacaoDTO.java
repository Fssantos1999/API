package com.EstoqueAPI.Estoque.DTO;

import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegistroMovDTO {

    private UUID idTransacao;
    private Integer quantidadeRecebida;
    private String regiaoSaida;
    private String regiaoEntrada;
    private LocalDateTime dataEntrada;
    private UUID estoqueId;
    private List<UUID>estoquesIds;

    public RegistroMovDTO() {}


    public RegistroMovDTO(UUID idTransacao, Integer quantidadeRecebida, String regiaoSaida,
                          String regiaoEntrada, LocalDateTime dataEntrada, UUID estoqueId, List<UUID> estoquesIds) {
        this.idTransacao = idTransacao;
        this.quantidadeRecebida = quantidadeRecebida;
        this.regiaoSaida = regiaoSaida;
        this.regiaoEntrada = regiaoEntrada;
        this.dataEntrada = dataEntrada;
        this.estoqueId = estoqueId;
        this.estoquesIds = estoquesIds;
    }
public RegistroMovDTO(RegistroMovimentacao registroMovimentacaoEntity) {
    if (registroMovimentacaoEntity.getEstoque() != null) {
        this.estoqueId = registroMovimentacaoEntity.getEstoque().getId();
    }
    BeanUtils.copyProperties(registroMovimentacaoEntity, this);
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

    public UUID getIdEstoque() {
        return estoqueId;
    }

    public void setIdEstoque(UUID idEstoque) {
        this.estoqueId = idEstoque;
    }

    public List<UUID> getEstoquesIds() {
        return estoquesIds;
    }

    public void setEstoquesIds(List<UUID> estoquesIds) {
        this.estoquesIds = estoquesIds;
    }
}
