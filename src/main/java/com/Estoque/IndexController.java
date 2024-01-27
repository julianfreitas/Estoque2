package com.Estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.lang.Long;


@RestController
@RequestMapping("/api") // RECEBE O INDEX DO HTML
public class IndexController{
    @Autowired
    private final Servico servico;

    @Autowired
    public IndexController(Servico servico){ //construtor
        this.servico = servico;
    }


    @PostMapping("/adicionar")
    public IndexModell adicionarDados(@RequestBody  IndexModell indexModell){  //metedo para adicionar novo produto
         return servico.adicionar(indexModell);

    }
    @GetMapping("/lista")
    public List<IndexModell> listarProdutos(){   //exibi todos os dados do banco
        return servico.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndexModell> buscarProduto(@PathVariable Long id) { //busca dados no banco pelo id
        Optional<IndexModell> indexModellOptional = servico.buscarId(id);
        return indexModellOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarId(@PathVariable("id") long id){ //deleta dados no banco pelo id
        servico.deletarId(id);
        return ResponseEntity.ok("deletado com sucesso");

    }


}
