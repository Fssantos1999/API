package com.EstoqueAPI.Estoque.Service;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstoqueService {
@Autowired
EstoqueRepository estoqueRepository;


    @Transactional
   public EstoqueDTO salvarProduto(EstoqueDTO estoqueDTO) {
      Estoque estoque = new Estoque();
      estoque.setTipoDoProduto(estoqueDTO.getTipoDoProduto());
      estoque.setNomeDoProduto(estoqueDTO.getNomeDoProduto());
      Estoque salvarEstoque = estoqueRepository.save(estoque);


//CONVERTE A ENTIDADE DE VOLTA PARA DTO

       EstoqueDTO salvarEstoqueDTO = new EstoqueDTO();
      salvarEstoqueDTO.setNomeDoProduto(estoque.getNomeDoProduto());
     salvarEstoqueDTO.setTipoDoProduto(estoque.getTipoDoProduto());


      return salvarEstoqueDTO;

   }

    public List<EstoqueDTO> ListarEstoque() {
        return estoqueRepository.findAll()
                .stream()
                .map(EstoqueDTO::new)
                .collect(Collectors.toList());
    }




}




