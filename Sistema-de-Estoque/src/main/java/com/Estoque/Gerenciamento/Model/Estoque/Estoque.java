package com.Estoque.Gerenciamento.Model.Estoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "estoque")
public class Estoque {

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






    
}
