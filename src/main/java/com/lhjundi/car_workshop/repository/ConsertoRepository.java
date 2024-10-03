package com.lhjundi.car_workshop.repository;

import com.lhjundi.car_workshop.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
