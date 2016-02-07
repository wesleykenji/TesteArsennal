package br.com.arsennal.teste.business.validators;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public abstract class ValidacoesComposite extends ValidadoresAbstract {

    protected Collection<ValidadoresAbstract> validadores = new ArrayList<ValidadoresAbstract>();

    public void add(ValidadoresAbstract validadores){
        this.validadores.add(validadores);
    }
}
