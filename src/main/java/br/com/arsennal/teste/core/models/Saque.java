package br.com.arsennal.teste.core.models;

import br.com.arsennal.teste.core.enumerations.Cedulas;

import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class Saque {

    private Map<Cedulas, Integer> qtdDeCedulas;
    private Integer valor;

    public void setQtdDeCedulas(Map<Cedulas, Integer> qtdDeCedulas) {
        this.qtdDeCedulas = qtdDeCedulas;
    }

    public Map<Cedulas, Integer> getQtdDeCedulas() {
        return qtdDeCedulas;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }
}
