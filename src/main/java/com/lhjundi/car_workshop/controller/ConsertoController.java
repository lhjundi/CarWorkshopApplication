package com.lhjundi.car_workshop.controller;

import com.lhjundi.car_workshop.conserto.AtualizacaoConsertoDTO;
import com.lhjundi.car_workshop.conserto.Conserto;
import com.lhjundi.car_workshop.conserto.ConsertoDTO;
import com.lhjundi.car_workshop.conserto.ListagemConsertoDTO;
import com.lhjundi.car_workshop.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(conserto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizacaoConsertoDTO dto){
        Conserto conserto = repository.getReferenceById(dto.id());
        conserto.atualizarInformacoes(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
    }

}
