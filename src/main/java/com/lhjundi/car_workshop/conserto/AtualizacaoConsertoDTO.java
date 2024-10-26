package com.lhjundi.car_workshop.conserto;

import com.lhjundi.car_workshop.mecanico.MecanicoDTO;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoConsertoDTO(
        @NotNull
        Long id,
        String saida,
        String nome,
        String experiencia
) {

}
