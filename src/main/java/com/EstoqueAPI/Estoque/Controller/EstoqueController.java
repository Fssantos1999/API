package com.EstoqueAPI.Estoque.Controller;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import com.EstoqueAPI.Estoque.Repository.EstoqueRepository;
import com.EstoqueAPI.Estoque.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void EstoqueController(){}

    @Autowired
    private EstoqueService estoqueService;
    //funcionando
    @GetMapping("/listarprodutos")
    public List<EstoqueDTO> listarProdutos(){
        return  estoqueService.ListarEstoque();
    }

    @GetMapping("/localizarproduto/{id}")
    public ResponseEntity<EstoqueDTO> localizarProduto(@PathVariable UUID id) {
        EstoqueDTO estoqueDTO = estoqueService.localizarProduto(id);
        if (estoqueDTO != null) {
            return ResponseEntity.ok(estoqueDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/adicionarProduto")
    public ResponseEntity<EstoqueDTO> adicionarProduto(@RequestBody EstoqueDTO estoqueDTO) {
        EstoqueDTO produtoSalvo = estoqueService.salvarProduto(estoqueDTO);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }


    @DeleteMapping("/deletarproduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
       estoqueService.deletarProduto(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    //PATCHMAPPING pois só quero atualizar uma parte da do estoque
    @PatchMapping("/adicionar-quantidade/{id}/{quantidade}")
    public EstoqueDTO adicionarQuantidade(@PathVariable UUID id, @PathVariable int quantidade) {
        return estoqueService.adicionarQuantidade(id, quantidade);
    }





}
