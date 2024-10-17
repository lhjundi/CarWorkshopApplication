package com.lhjundi.car_workshop.conserto;

import com.lhjundi.car_workshop.mecanico.MecanicoDTO;
import com.lhjundi.car_workshop.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String entrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String saida,

        @NotNull
        @Valid
        MecanicoDTO mecanico,

        @NotNull
        @Valid
        VeiculoDTO veiculo) {
}
