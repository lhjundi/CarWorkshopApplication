package com.lhjundi.car_workshop.conserto;

import com.lhjundi.car_workshop.mecanico.Mecanico;
import com.lhjundi.car_workshop.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entrada;
    private String saida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(ConsertoDTO dto){
        this.entrada = dto.entrada();
        this.saida = dto.saida();
        this.mecanico = new Mecanico(dto.mecanico());
        this.veiculo = new Veiculo(dto.veiculo());

    }
}
