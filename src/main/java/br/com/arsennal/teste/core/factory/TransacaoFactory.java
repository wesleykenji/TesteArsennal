package br.com.arsennal.teste.core.factory;

import br.com.arsennal.teste.services.TransacaoService;
import br.com.arsennal.teste.services.impl.TransacaoServiceImpl;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class TransacaoFactory {

    private static TransacaoService transacaoService;

    public static TransacaoService getInstance(){
        transacaoService = new TransacaoServiceImpl();
        return transacaoService;
    }
}
