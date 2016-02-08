package br.com.arsennal.teste.core.builder;

import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import br.com.arsennal.teste.core.models.Saque;
import br.com.arsennal.teste.core.models.Transacao;
import com.mongodb.DBObject;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class TransacaoBuilder {

    public static Transacao construirTransacaoDeSaque(SaqueBuilder saqueBuilder) {
        Transacao transacao = new Transacao();

        Saque saque = saqueBuilder.buildSaque();

        transacao.setSaque(saque);
        transacao.setValor(saque.getValor());

        return transacao;
    }

    public static Transacao construirTransacaoPorMapa(Map map) {
        Transacao transacao = new Transacao();

        transacao.setValor(Integer.valueOf((String) map.get("valor")));
        Date dataCriacao = (Date) map.get("dataCriacao");

        DateTime dateTime = new DateTime(dataCriacao);
        transacao.setDataTransacao(dateTime);
        transacao.setTipoOperacao(TipoOperacao.valueOf((String) map.get("tipoOperacao")));

        DBObject dbObject = (DBObject) map.get("notas");
        SaqueBuilder saque = new SaqueBuilder(transacao.getValor());

        Map mapCedulas = dbObject.toMap();
        for (Object key : mapCedulas.keySet()) {
            saque.addCedulas((Integer) mapCedulas.get(key), Cedulas.valueOf((String) key));
        }

        transacao.setSaque(saque.buildSaque());
        return transacao;
    }
}
