package com.EstoqueAPI.Estoque.Controller;

import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Service.RegistroMovimentacaoService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistroMovimentacaoController {

    @Autowired
    private RegistroMovimentacaoService registroMovimentacaoService;

    @GetMapping
    public ResponseEntity<List<RegistroMovimentacaoDTO>> listarTodos() {
        List<RegistroMovimentacaoDTO> movimentacoes = registroMovimentacaoService.listarTodos();
        return ResponseEntity.ok(movimentacoes);
    }

   // @PostMapping("/entrada-movimentacao")
   / public RegistroMovimentacaoDTO realizarMovimentacao(@RequestBody RegistroMovimentacaoDTO movimentacaoDTO) {

   // }





}
