package com.EstoqueAPI.Estoque.Model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "RegistroMovimentação")
public class RegistroMovimentacao implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTransacao;
    private Integer quantidadeRecebida;
    private String regiaoSaida;
    private String regiaoEntrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "estoque_id", referencedColumnName = "id")
    @JsonBackReference
    private Estoque estoque;


    public Estoque getEstoque() {
        return estoque;
    }

    public RegistroMovimentacao() {}

    public RegistroMovimentacao(Integer quantidadeRecebida,
                                String regiaoSaida,
                                String regiaoEntrada, LocalDateTime dataEntrada,
                                 Estoque estoque) {
        this.estoque = estoque;
        this.quantidadeRecebida = quantidadeRecebida;
        this.regiaoSaida = regiaoSaida;
        this.regiaoEntrada = regiaoEntrada;
        this.dataEntrada = dataEntrada;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
        if (!estoque.getMovimentacoes().contains(this)) {
            estoque.getMovimentacoes().add(this);
        }
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getRegiaoEntrada() {
        return regiaoEntrada;
    }

    public void setRegiaoEntrada(String regiaoEntrada) {
        this.regiaoEntrada = regiaoEntrada;
    }

    public String getRegiaoSaida() {
        return regiaoSaida;
    }

    public Integer getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(Integer quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }

    public UUID getIdTransacao() {
        return idTransacao;
    }


}
