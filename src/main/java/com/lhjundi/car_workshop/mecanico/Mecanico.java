package com.lhjundi.car_workshop.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String experiencia;

    public Mecanico(MecanicoDTO dto){
        this.nome = dto.nome();
        this.experiencia = dto.experiencia();
    }
}
