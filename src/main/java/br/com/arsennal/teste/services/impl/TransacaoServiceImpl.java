package br.com.arsennal.teste.services.impl;

import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import br.com.arsennal.teste.core.models.Transacao;
import br.com.arsennal.teste.infra.dao.TransacaoDAO;
import br.com.arsennal.teste.infra.dao.impl.TransacaoDAOImpl;
import br.com.arsennal.teste.services.TransacaoService;

import java.util.List;
import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class TransacaoServiceImpl implements TransacaoService {

    private TransacaoDAO transacaoDAO = new TransacaoDAOImpl();

    @Override
    public void inserirTransacao(Transacao transacao) {
        transacaoDAO.inserirTransacao(transacao);
    }

    @Override
    public List<Transacao> listarTransacoesPorDataDecrescente(TipoOperacao tipoOperacao) {
        return transacaoDAO.listarTransacoesPorDataDecrescente(tipoOperacao);
    }

    @Override
    public Map<Cedulas,Integer> obterQtdTotalDeCedulasSacadas() {
        return transacaoDAO.obterQtdTotalDeCedulasSacadas();
    }

    @Override
    public Integer obterMediaDoValorSacado() {
        return transacaoDAO.obterMediaDoValorSacado();
    }


}
