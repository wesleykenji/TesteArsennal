package br.com.arsennal.teste.infra;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by wesley_kenji on 06/02/16.
 * Por motivos didaticos essa classe não possui seus atributos externalizados
 */
public class Conexao {

    private static MongoClient mongo = null;

    public Conexao () {
        try {
            mongo = new MongoClient( "localhost" , 27017 );

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static DB getDatabase(){
        DB db = mongo.getDB("TesteArsennal");
        return db;
    }

}
