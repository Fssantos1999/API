package com.Estoque.Gerenciamento.Model.Estoque;

import com.Estoque.Gerenciamento.Model.EntradaProdutos.entradaDeProdutos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "estoque")
public class Estoque {
    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL)
    private List<entradaDeProdutos> entradas = new ArrayList<>();

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private String marcaProduto;

    @Column(name = "distribuidora")
    private String distribuidora;


    @Column(nullable = false)
    private String tipoProduto;


    public void adicionarEntrada(entradaDeProdutos entrada) {
        this.entradas.add(entrada);
    }


}
