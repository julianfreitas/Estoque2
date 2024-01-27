package com.Estoque;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servico {

    private final Repositorio repositorio;  //instancia da classe do repositorio

    @Autowired
    public Servico(Repositorio repositorio){ //construtor
        this.repositorio = repositorio;
    }
    @Transactional
    public IndexModell adicionar(IndexModell indexModell){
       return repositorio.save(indexModell);  //salva um novo produto apartir da class modelo no repositorio que leva ao banco

    }

    public List<IndexModell> listarProdutos() {  //lista todos os dados do banco
        return repositorio.findAll();
    }
    public Optional<IndexModell> buscarId(long id){
        return repositorio.findById(id);
    }

    public void deletarId(long id){
        repositorio.deleteById(id);
    }

}
