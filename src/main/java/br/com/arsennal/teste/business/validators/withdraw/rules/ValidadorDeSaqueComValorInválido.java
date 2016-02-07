package br.com.arsennal.teste.business.validators.withdraw.rules;

import br.com.arsennal.teste.business.DispensadorDeCedulas;
import br.com.arsennal.teste.business.validators.RetornoValidacao;
import br.com.arsennal.teste.business.validators.ValidacoesComposite;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class ValidadorDeSaqueComValorInválido extends ValidacoesComposite {

    @Override
    public RetornoValidacao validarRegra(Integer valor) {
        System.out.println("C=ValidadorDeSaqueComValorInválido executando... ");
        RetornoValidacao retornoValidacao = new RetornoValidacao();

        DispensadorDeCedulas dispensadorDeCedulas = new DispensadorDeCedulas(valor, true);
        Integer resto = dispensadorDeCedulas.obtemValorRestante();

        if(resto > 0){
            retornoValidacao.setEhValido(false);
            retornoValidacao.setMensagem("O valor digitado é inválido! O valor excede a disponibilidade de notas em caixa!");
            return retornoValidacao;
        }

        return retornoValidacao;
    }
}
