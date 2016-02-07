package br.com.arsennal.teste.core.exception;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class SaqueInvalidoException extends RuntimeException {

    String erro = "";

    public SaqueInvalidoException(String erro) {
        this.erro = erro;
    }

    @Override
    public String getMessage() {
        return this.erro;
    }
}
