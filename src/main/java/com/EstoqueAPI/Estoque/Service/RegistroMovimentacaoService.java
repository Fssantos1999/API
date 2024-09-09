package com.EstoqueAPI.Estoque.Service;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import com.EstoqueAPI.Estoque.Repository.RegistroMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return null;
    }

    /**
     * Busca todas as movimentações.
     *
     * @return uma lista de DTOs de movimentação
     */
    public List<RegistroMovimentacaoDTO> buscarTodos() {
            return null;
    }


    public void deleteRegistroMovimentacao(UUID id) {
        registroMovimentacaoRepository.deleteById(id);
    }


}