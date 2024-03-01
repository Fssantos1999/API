package com.Estoque.Gerenciamento.Model.EntradaProdutos;

import java.time.LocalDateTime;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * EntradaDeProdutos
 */
public class EntradaDeProdutos {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Estoque Estoque;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    @Column(nullable = false)
    private Double precoUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    
}