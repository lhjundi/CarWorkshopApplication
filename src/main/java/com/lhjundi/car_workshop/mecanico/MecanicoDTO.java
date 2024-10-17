package com.lhjundi.car_workshop.mecanico;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(

        @NotBlank
        String nome,

        String experiencia) {
}
