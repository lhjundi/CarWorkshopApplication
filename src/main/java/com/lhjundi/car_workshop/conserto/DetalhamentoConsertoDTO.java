package com.lhjundi.car_workshop.conserto;

import com.lhjundi.car_workshop.mecanico.Mecanico;
import com.lhjundi.car_workshop.mecanico.MecanicoDTO;
import com.lhjundi.car_workshop.veiculo.Veiculo;
import com.lhjundi.car_workshop.veiculo.VeiculoDTO;

public record DetalhamentoConsertoDTO(
        Long id,
        String entrada,
        String saida,
        Mecanico mecanico,
        Veiculo veiculo
) {
    public DetalhamentoConsertoDTO(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo()
        );
    }
}
