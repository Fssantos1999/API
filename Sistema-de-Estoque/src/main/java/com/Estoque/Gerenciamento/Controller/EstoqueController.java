package com.Estoque.Gerenciamento.Controller;

import java.util.List;
import java.util.Optional;

import com.Estoque.Gerenciamento.Model.EntradaProdutos.entradaDeProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estoque.Gerenciamento.Model.Estoque.Estoque;
import com.Estoque.Gerenciamento.Repository.EstoqueRepositoriy;

/**
 *
 * Status HTTP:
 *
 * 201 - Criado: Tudo funcionou conforme o esperado. (OK)
 * 400 - Bad Request: A solicitação era inaceitável, muitas vezes devido à falta
 * de um parâmetro obrigatório.
 * 401 - Não autorizado: Nenhuma chave de API válida fornecida.
 * 403 - Proibido: A chave API não possui permissões para realizar a
 * solicitação.
 * 404 - Não Encontrado: O recurso solicitado não existe.(NOT FOUND)
 * 409 - Conflito: A solicitação entra em conflito com outra solicitação (talvez
 * devido ao uso da mesma chave idempotente).
 * 429 - Muitas solicitações: Muitas solicitações chegam à API muito
 * rapidamente. Recomendamos uma retirada exponencial de suas solicitações.
 * 500, 502, 503, 504 - Erros de servidor: algo deu errado no final da API
 * (estes são raros).
 */
@RestController
public class EstoqueController {

    @Autowired
    EstoqueRepositoriy repositoriy;

    @RequestMapping("/api/estoque")

    public List<Estoque> listarTodos() {
        return repositoriy.findAll();
    }

    /*
     * @GetMapping(value = "{distribuidoras}")
     * public ResponseEntity <?> findByDistribuidora(@PathVariable String
     * distribuidora){
     * Optional <Estoque> obj = repositoriy.findByDistribuidora(distribuidora);
     * 
     * if (obj.isPresent()) {
     * return ResponseEntity.ok(obj.get());
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     */
    entradaDeProdutos entradaDeProdutos;

    @PostMapping(value = "/api/adicionarEstoque")
    public Estoque adicionarProduto(@RequestBody Estoque estoque) {
        return repositoriy.save(estoque);

    }

    @GetMapping(value = "/api/localizarProduto/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<Estoque> searchID = repositoriy.findById(id);
            if (searchID.isPresent()) {
                return ResponseEntity.ok(searchID.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/api/deletarProduto/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        try {
            repositoriy.deleteById(id);
        

            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar produto");
        }
    }

    @PutMapping(value = "/api/atualizarProduto/{id}")
    public Estoque atualizar(@RequestBody Estoque estoque) {
        return repositoriy.save(estoque);
    }


    @PostMapping(value ="/api/adicionarEntradaProduto")
    public entradaDeProdutos entradaProduto(@PathVariable entradaDeProdutos entrada){
        return  entradaProduto(entrada);
    }



}
