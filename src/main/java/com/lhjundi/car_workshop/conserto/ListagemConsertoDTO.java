package com.lhjundi.car_workshop.conserto;

public record ListagemConsertoDTO(
        String entrada,
        String saida,
        String nome,
        String marca,
        String modelo
){
    public ListagemConsertoDTO(Conserto conserto){
        this(
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getAno()
        );
    }
}
