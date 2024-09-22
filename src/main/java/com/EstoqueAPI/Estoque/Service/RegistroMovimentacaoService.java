package com.EstoqueAPI.Estoque.Service;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.EstoqueMapStruct.ConverterDTOeEntity;
import com.EstoqueAPI.Estoque.EstoqueMapStruct.RegistroConverterDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import com.EstoqueAPI.Estoque.Repository.RegistroMovimentacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RegistroMovimentacaoService {

    @Autowired
    private RegistroMovimentacaoRepository registroMovimentacaoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    RegistroConverterDTO registroConverterDTO;

    /**
     * Adiciona uma nova movimentação e atualiza o estoque.
     *
     * @param dto a DTO de movimentação
     * @param id  o ID do estoque a ser atualizado
     * @return a lista atualizada de estoques
     */
    public List<EstoqueDTO> adicionarMovimentacao(RegistroMovimentacaoDTO dto, UUID id) {
        Optional<Estoque> estoqueOptional = estoqueRepository.findById(id);

        if (estoqueOptional.isPresent()) {
            Estoque estoque = estoqueOptional.get();

            // Atualiza a quantidade do estoque
            estoque.setQuantidade(estoque.getQuantidade() + dto.getQuantidadeRecebida());

            // Cria um novo registro de movimentação
            RegistroMovimentacao movimentacao = new RegistroMovimentacao();
            movimentacao.setQuantidadeRecebida(dto.getQuantidadeRecebida());
            movimentacao.setRegiaoSaida(dto.getRegiaoSaida());
            movimentacao.setRegiaoEntrada(dto.getRegiaoEntrada());
            movimentacao.setDataEntrada(LocalDateTime.now()); // Define a data atual
            movimentacao.setEstoque(estoque); // Associa o estoque

            // Salva o registro de movimentação
            registroMovimentacaoRepository.save(movimentacao);

            // Atualiza o estoque
            estoqueRepository.save(estoque);

            // Retorna a lista atualizada de EstoqueDTO
            return estoqueRepository.findAll().stream()
                    .map(e -> new EstoqueDTO(e.getId(), e.getNomeDoProduto(), e.getQuantidade(), e.getTipoDoProduto()))
                    .collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("Produto não encontrado no estoque.");
        }
    }



    public List<RegistroMovimentacaoDTO> buscarTodos() {
          return   registroConverterDTO.toDTO(registroMovimentacaoRepository.findAll());
    }


    public void deleteRegistroMovimentacao(UUID id) {
        registroMovimentacaoRepository.deleteById(id);
    }









}