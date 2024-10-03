package com.lhjundi.car_workshop.conserto;

import com.lhjundi.car_workshop.mecanico.MecanicoDTO;
import com.lhjundi.car_workshop.veiculo.VeiculoDTO;

public record ConsertoDTO(
        String entrada,
        String saida,
        MecanicoDTO mecanico,
        VeiculoDTO veiculo) {
}
