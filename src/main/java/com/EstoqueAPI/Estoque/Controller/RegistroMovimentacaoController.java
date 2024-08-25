package com.EstoqueAPI.Estoque.Controller;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.EstoqueAPI.Estoque.Repository.RegistroMovimentacaoRepository;
import com.EstoqueAPI.Estoque.Service.EstoqueService;
import com.EstoqueAPI.Estoque.Service.RegistroMovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "/api")
public class RegistroMovimentacaoController {

    private  EstoqueService estoqueService;
    private final RegistroMovimentacaoService registroMovimentacaoService;
    @Autowired
    private final RegistroMovimentacaoRepository registroMovimentacaoRepository;

    public RegistroMovimentacaoController(RegistroMovimentacaoService registroMovimentacaoService, RegistroMovimentacaoRepository registroMovimentacaoRepository) {
        this.registroMovimentacaoService = registroMovimentacaoService;
        this.registroMovimentacaoRepository = registroMovimentacaoRepository;
    }
    /**
     *Busca por ID o produto  e atualiza os Registros de Movimentações.
     *
     * @return a lista de movimentações
     */
    @PostMapping("/{id}/movimentacao")
    public ResponseEntity<List<EstoqueDTO>> adicionarMovimentacao(
            @RequestBody RegistroMovimentacaoDTO dto,
            @PathVariable UUID id) {
        try {
            List<EstoqueDTO> estoquesAtualizados = registroMovimentacaoService.adicionarMovimentacao(dto, id);
            return ResponseEntity.ok(estoquesAtualizados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    /**
     * Busca todas as movimentações.
     *
     * @return a lista de movimentações
     */
    @GetMapping("/movimentacoes")
    public ResponseEntity<List<RegistroMovimentacaoDTO>> buscarMovimentacoes() {
        try {
            List<RegistroMovimentacaoDTO> movimentacoes = registroMovimentacaoService.buscarTodos();
            return ResponseEntity.ok(movimentacoes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletarMovimentacao(@PathVariable UUID id) {
        if (registroMovimentacaoRepository.existsById(id)) {
            return ResponseEntity.ok("Registro deletado com Sucesso !");
        }else {
            return  ResponseEntity.badRequest().body("Registro Não Encontrado !");
        }
    }

}







