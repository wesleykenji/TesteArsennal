package br.com.arsennal.teste.infra;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class TesteConexao {

    public static void main(String[] args) {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongo.getDB("TesteArsennal");
        System.out.println(db);
    }
}
