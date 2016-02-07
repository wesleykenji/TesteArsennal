package br.com.arsennal.teste.business.validators;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class RetornoValidacao {
    private Boolean ehValido = true;
    private String mensagem = "";

    public void setEhValido(Boolean ehValido) {
        this.ehValido = ehValido;
    }

    public boolean ehValido() {
        return this.ehValido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
