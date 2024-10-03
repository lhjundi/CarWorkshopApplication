package com.lhjundi.car_workshop.controller;

import com.lhjundi.car_workshop.conserto.Conserto;
import com.lhjundi.car_workshop.conserto.ConsertoDTO;
import com.lhjundi.car_workshop.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody ConsertoDTO dados){
        System.out.println(dados);
        repository.save(new Conserto(dados));
    }
}
