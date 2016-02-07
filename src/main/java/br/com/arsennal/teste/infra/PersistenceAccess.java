package br.com.arsennal.teste.infra;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public abstract class PersistenceAccess extends Conexao{

    private Conexao conexao = new Conexao();

    public Conexao getConexao() {
        return conexao;
    }
}
