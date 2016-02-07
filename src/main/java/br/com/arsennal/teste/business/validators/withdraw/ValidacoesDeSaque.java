package br.com.arsennal.teste.business.validators.withdraw;

import br.com.arsennal.teste.business.validators.RetornoValidacao;
import br.com.arsennal.teste.business.validators.ValidacoesComposite;
import br.com.arsennal.teste.business.validators.ValidadoresAbstract;
import br.com.arsennal.teste.business.validators.withdraw.rules.ValidadorDeLimiteInferior;
import br.com.arsennal.teste.business.validators.withdraw.rules.ValidadorDeLimiteSuperior;
import br.com.arsennal.teste.business.validators.withdraw.rules.ValidadorDeSaqueComValorInválido;
import br.com.arsennal.teste.core.exception.SaqueInvalidoException;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class ValidacoesDeSaque extends ValidacoesComposite {

    public ValidacoesDeSaque() {
        validadores.add(new ValidadorDeLimiteInferior());
        validadores.add(new ValidadorDeLimiteSuperior());
        validadores.add(new ValidadorDeSaqueComValorInválido());
    }

    @Override
    public RetornoValidacao validarRegra(Integer valor) {

        RetornoValidacao retorno = new RetornoValidacao();

        for (ValidadoresAbstract validador : validadores){
            retorno = validador.validarRegra(valor);
            if(!retorno.ehValido()){
                throw new SaqueInvalidoException(retorno.getMensagem());
            }
        }

        return retorno;
    }
}
