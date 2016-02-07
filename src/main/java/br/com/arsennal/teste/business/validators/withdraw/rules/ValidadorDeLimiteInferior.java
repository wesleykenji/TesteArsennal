package br.com.arsennal.teste.business.validators.withdraw.rules;

import br.com.arsennal.teste.business.validators.RetornoValidacao;
import br.com.arsennal.teste.business.validators.ValidacoesComposite;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class ValidadorDeLimiteInferior extends ValidacoesComposite {

    private final static Integer LIMITE_INFERIOR_SAQUE = 2;

    @Override
    public RetornoValidacao validarRegra(Integer valor) {
        System.out.println("C=ValidadorDeLimiteInferior executando... ");
        RetornoValidacao retornoValidacao = new RetornoValidacao();

        if(LIMITE_INFERIOR_SAQUE >= valor){
            retornoValidacao.setEhValido(false);
            retornoValidacao.setMensagem("Saque Inválido! Saques devem ser maiores que R$ " + LIMITE_INFERIOR_SAQUE);
            return retornoValidacao;
        }

        return retornoValidacao;
    }
}
