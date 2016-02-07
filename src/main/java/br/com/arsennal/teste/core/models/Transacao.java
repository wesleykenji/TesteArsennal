package br.com.arsennal.teste.core.models;

import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class Transacao{

    private TipoOperacao tipoOperacao;
    private DateTime dataTransacao;
    private Saque saque;
    private Integer valor;

    public Transacao() {
        dataTransacao = new DateTime();
    }


    public void setSaque(Saque saque) {
        this.saque = saque;
    }

    public Saque getSaque() {
        return saque;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public DateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(DateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }
}
