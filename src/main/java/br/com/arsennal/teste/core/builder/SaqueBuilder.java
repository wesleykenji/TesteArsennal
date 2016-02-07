package br.com.arsennal.teste.core.builder;

import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.models.Saque;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class SaqueBuilder{

    private Map<Cedulas, Integer> qtdDeCedulas = new HashMap<Cedulas, Integer>();
    private Integer valorOriginal;

    public SaqueBuilder (final Integer valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public void addCedulas(Integer qtdCedula, Cedulas cedula){
        qtdDeCedulas.put(cedula, qtdCedula);
    }

    public Saque buildSaque() {
        Saque saque = new Saque();

        saque.setQtdDeCedulas(qtdDeCedulas);
        saque.setValor(valorOriginal);

        return saque;
    }
}
