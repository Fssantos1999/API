package com.EstoqueAPI.Estoque.Controller;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import com.EstoqueAPI.Estoque.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void EstoqueController(){}

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/listarProdutos")
    public List<EstoqueDTO> listarProdutos(){
        return  estoqueService.ListarEstoque();
    }

    @PostMapping("/adicionarproduto")
    public ResponseEntity<EstoqueDTO> adicionarProduto(@RequestBody EstoqueDTO estoqueDTO) {
        EstoqueDTO produtoSalvo = estoqueService.salvarProduto(estoqueDTO);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/atualizarEstoque")
    public ResponseEntity<Void> atualizarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        estoqueService.salvarProduto(estoqueDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletarProduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
       estoqueService.deletarProduto(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

}
