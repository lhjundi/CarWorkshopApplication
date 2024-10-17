package com.lhjundi.car_workshop.controller;

import com.lhjundi.car_workshop.conserto.Conserto;
import com.lhjundi.car_workshop.conserto.ConsertoDTO;
import com.lhjundi.car_workshop.conserto.ListagemConsertoDTO;
import com.lhjundi.car_workshop.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsertoDTO dados){
        //System.out.println(dados);
        repository.save(new Conserto(dados));
    }
/*
    @GetMapping
    public List<Conserto> listar(){
        return repository.findAll();
    }
*/
    @GetMapping
    public Page<Conserto> listar(Pageable paginacao){
        return repository.findAll(paginacao);
    }
    @GetMapping("relatorios")
    public List<ListagemConsertoDTO> relatorioConsertos(){
        return repository.findAll()
                .stream()
                .map(ListagemConsertoDTO::new)
                .toList();
    }
}
