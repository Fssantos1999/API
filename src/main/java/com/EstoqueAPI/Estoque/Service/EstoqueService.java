package com.EstoqueAPI.Estoque.Service;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.EstoqueMapStruct.ConverterDTOeEntity;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstoqueService {
    @Autowired
    EstoqueRepository estoqueRepository;
    @Autowired
    ConverterDTOeEntity mapper;

    @Transactional
    public EstoqueDTO salvarProduto(EstoqueDTO estoqueDTO) {

        return mapper.entidadeParaDTO(estoqueRepository.save(mapper.DTOParaEntidade(estoqueDTO)));


    }


    public List<EstoqueDTO> ListarEstoque() {

      return mapper.entidadeParaListDTO(estoqueRepository.findAll());

    }


    @Transactional
    public ResponseEntity<?> deletarProduto(UUID id) {
        if (estoqueRepository.existsById(id)) {
            estoqueRepository.deleteById(id);
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public EstoqueDTO localizarProduto(UUID id) {
        return mapper.entidadeParaDTO(estoqueRepository.findById(id).get());
    }
    @Transactional
    //Passei o UUID ID para o corpo, assim posso fazer alteração direto na URL da api
    public EstoqueDTO adicionarQuantidade(UUID id, int quantidade) {
        Optional<Estoque> estoque = estoqueRepository.findById(id);

        if (estoque.isPresent()) {
            Estoque estoqueExistente = estoque.get();
            estoqueExistente.setQuantidade(estoqueExistente.getQuantidade() + quantidade);
            estoqueRepository.save(estoqueExistente);
            //Transformando novamente o Estoque para DTO
            EstoqueDTO estoqueDTO = new EstoqueDTO();
            estoqueDTO.setNomeDoProduto(estoqueExistente.getNomeDoProduto());
            estoqueDTO.setTipoDoProduto(estoqueExistente.getTipoDoProduto());
            estoqueDTO.setQuantidade(estoqueExistente.getQuantidade());
            estoqueDTO.setFilial(estoqueExistente.getFilial());

            return estoqueDTO;
        } else {
            throw new RuntimeException("Produto não encontrado");
        }





    }








    }








