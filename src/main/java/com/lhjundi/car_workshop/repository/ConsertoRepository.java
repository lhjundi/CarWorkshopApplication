package com.lhjundi.car_workshop.repository;

import com.lhjundi.car_workshop.conserto.Conserto;
import com.lhjundi.car_workshop.conserto.ListagemConsertoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
