package com.EstoqueAPI.Estoque.Service;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import com.EstoqueAPI.Estoque.Repository.RegistroMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RegistroMovimentacaoService {

    @Autowired
    private RegistroMovimentacaoRepository registroMovimentacaoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    /**
     * Adiciona uma nova movimentação e atualiza o estoque.
     *
     * @param dto a DTO de movimentação
     * @param id  o ID do estoque a ser atualizado
     * @return a lista atualizada de estoques
     */
    public List<EstoqueDTO> adicionarMovimentacao(RegistroMovimentacaoDTO dto, UUID id) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado com o ID: " + id));

        RegistroMovimentacao movimentacao = new RegistroMovimentacao();
        movimentacao.setQuantidadeRecebida(dto.getQuantidadeRecebida());
        movimentacao.setRegiaoSaida(dto.getRegiaoSaida());  // Certifique-se de que o valor não é null
        movimentacao.setRegiaoEntrada(dto.getRegiaoEntrada()); // Certifique-se de que o valor não é null
        movimentacao.setDataEntrada(dto.getDataEntrada());
        movimentacao.setEstoque(estoque);

        registroMovimentacaoRepository.save(movimentacao);

        Integer novaQuantidade = estoque.getQuantidade() + dto.getQuantidadeRecebida();
        estoque.setQuantidade(novaQuantidade);

        estoqueRepository.save(estoque);

        return estoqueRepository.findAll().stream()
                .map(EstoqueDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Busca todas as movimentações.
     *
     * @return uma lista de DTOs de movimentação
     */
    public List<RegistroMovimentacaoDTO> buscarTodos() {
        return registroMovimentacaoRepository.findAll().stream()
                .map(RegistroMovimentacaoDTO::new)
                .collect(Collectors.toList());
    }











}
