package br.com.arsennal.teste.infra.dao.impl;

import br.com.arsennal.teste.core.builder.TransacaoBuilder;
import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import br.com.arsennal.teste.core.models.Transacao;
import br.com.arsennal.teste.infra.PersistenceAccess;
import br.com.arsennal.teste.infra.dao.TransacaoDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class TransacaoDAOImpl extends PersistenceAccess implements TransacaoDAO {

    @Override
    public void inserirTransacao(Transacao transacao) {
        DB db = getDatabase();

        BasicDBObject documentCedula = new BasicDBObject();
        documentCedula.putAll(transacao.getSaque().getQtdDeCedulas());

        DBCollection table = db.getCollection("Transacao");
        BasicDBObject document = new BasicDBObject();
        document.put("valor", transacao.getValor().toString());

        document.put("dataCriacao", transacao.getDataTransacao().toDate());
        document.put("tipoOperacao", TipoOperacao.SAQUE.toString());
        document.append("notas", documentCedula);

        table.insert(document);

    }

    @Override
    public List<Transacao> listarTransacoesPorDataDecrescente(TipoOperacao tipoOperacao) {
        DB db = getDatabase();

        DBCollection table = db.getCollection("Transacao");
        BasicDBObject document = new BasicDBObject();
        document.put("dataCriacao", -1);

        DBCursor sort = table.find(null).sort(document);
        List<DBObject> dbObjects = sort.toArray();
        List<Transacao> transacoes = new ArrayList<>();
        for (DBObject dbObject : dbObjects){
            Transacao transacao = TransacaoBuilder.construirTransacaoPorMapa(dbObject.toMap());
            transacoes.add(transacao);
        }

        return transacoes;
    }

    @Override
    public Map<Cedulas, Integer> obterQtdTotalDeCedulasSacadas() {
        DB db = getDatabase();

        Map<Cedulas,Integer> total = new HashMap<>();
        DBCollection table = db.getCollection("Transacao");
        BasicDBObject document = new BasicDBObject();
        document.put("notas", 1);
        document.put("_id", 0);

        DBCursor cursor = table.find(null, document);
        List<DBObject> dbObjects = cursor.toArray();

        for (DBObject dbObject : dbObjects){
            DBObject object = (DBObject) dbObject.toMap().get("notas");
            Map mapCedulas = object.toMap();

            for (Object key : mapCedulas.keySet()) {

                Cedulas chave = Cedulas.valueOf((String) key);
                Integer valorOriginal = (Integer) mapCedulas.get(key);

                populaMapDeCedulas(total, chave, valorOriginal);

            }
        }

        return total;
//        db.Transacao.find({}, { "notas": 1, "_id" : 0 })

    }

    private void populaMapDeCedulas(Map<Cedulas, Integer> total, Cedulas chave, Integer valorOriginal) {
        if(total.containsKey(chave)){
            Integer temporario = total.get(chave);
            temporario += valorOriginal;
            total.put(chave, temporario);
        } else {
            total.put(chave, valorOriginal);
        }
    }

    @Override
    public Integer obterMediaDoValorSacado() {
        DB db = getDatabase();
        Integer valorTotal = 0;
        Integer qtdTotal = 0;

        DateTime dataAntiga = new DateTime();
        dataAntiga = dataAntiga.minusDays(30);

        DBCollection table = db.getCollection("Transacao");

        BasicDBObject document = new BasicDBObject();
        document.put("valor", 1);
        document.put("dataCriacao", 1);
        document.put("_id", 0);

        BasicDBObject query = new BasicDBObject();
        query.put("dataCriacao", BasicDBObjectBuilder.start("$gte", dataAntiga.toDate()).add("$lte", new DateTime().toDate()).get());
        DBCursor objects = table.find(query, document).sort(new BasicDBObject("dataCriacao", -1));

        List<DBObject> dbObjects = objects.toArray();

        qtdTotal = dbObjects.size();
        for(DBObject dbObject : dbObjects){
            Map mapObject = dbObject.toMap();
            valorTotal += Integer.valueOf((String) mapObject.get("valor"));
        }

        Integer mediaTotal = valorTotal / qtdTotal;
        return mediaTotal;
//        db.Transacao.find({}, { "valor": 1, "_id" : 0 })
    }
}
