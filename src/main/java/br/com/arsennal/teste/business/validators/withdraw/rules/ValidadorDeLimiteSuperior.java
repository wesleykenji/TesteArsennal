package br.com.arsennal.teste.business.validators.withdraw.rules;

import br.com.arsennal.teste.business.validators.RetornoValidacao;
import br.com.arsennal.teste.business.validators.ValidadoresAbstract;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class ValidadorDeLimiteSuperior extends ValidadoresAbstract {

    private final static Integer LIMITE_SUPERIOR_SAQUE = 1000;

    @Override
    public RetornoValidacao validarRegra(Integer valor) {
        System.out.println("C=ValidadorDeLimiteSuperior executando... ");
        RetornoValidacao retornoValidacao = new RetornoValidacao();

        if(valor >= LIMITE_SUPERIOR_SAQUE){
            retornoValidacao.setEhValido(false);
            retornoValidacao.setMensagem("Saque inválido! Saques devem ser menores que R$ " + LIMITE_SUPERIOR_SAQUE);
            return retornoValidacao;
        }

        return retornoValidacao;
    }
}
