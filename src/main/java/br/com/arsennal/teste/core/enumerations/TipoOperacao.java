package br.com.arsennal.teste.core.enumerations;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public enum TipoOperacao {

    SAQUE("SAQUE");

    TipoOperacao(String tipoOperacao){
        this.tipoOperacao = tipoOperacao;
    }

    private String tipoOperacao;
}
