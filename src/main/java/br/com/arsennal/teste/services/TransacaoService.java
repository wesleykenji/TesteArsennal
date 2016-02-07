package br.com.arsennal.teste.services;

import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import br.com.arsennal.teste.core.models.Transacao;

import java.util.List;
import java.util.Map;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public interface TransacaoService {
    public void inserirTransacao(Transacao transacao);

    List<Transacao> listarTransacoesPorDataDecrescente(TipoOperacao tipoOperacao);

    Map<Cedulas, Integer> obterQtdTotalDeCedulasSacadas();

    Integer obterMediaDoValorSacado();
}
