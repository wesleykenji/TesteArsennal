package br.com.arsennal.teste;

import br.com.arsennal.teste.business.DispensadorDeCedulas;
import br.com.arsennal.teste.business.validators.withdraw.ValidacoesDeSaque;
import br.com.arsennal.teste.core.builder.SaqueBuilder;
import br.com.arsennal.teste.core.builder.TransacaoBuilder;
import br.com.arsennal.teste.core.enumerations.Cedulas;
import br.com.arsennal.teste.core.enumerations.TipoOperacao;
import br.com.arsennal.teste.core.exception.SaqueInvalidoException;
import br.com.arsennal.teste.core.factory.TransacaoFactory;
import br.com.arsennal.teste.core.models.Transacao;
import br.com.arsennal.teste.services.TransacaoService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        boolean redirecionaFluxo = true;

        System.out.println("=======     ATM    ==========");
        while(redirecionaFluxo) {
            //receber saque
            System.out.println("Digite o valor do saque: ");
            Scanner scanner = new Scanner(System.in);
            Integer valor = scanner.nextInt();

            //validar regras sobre valor de saque
            ValidacoesDeSaque validacoesDeSaque = new ValidacoesDeSaque();
            try {
                validacoesDeSaque.validarRegra(valor);
            } catch (SaqueInvalidoException ex) {
                System.out.println(ex.getMessage());
                continue;
            }

            //liberar menor quantidade de cedulas possiveis
            DispensadorDeCedulas dispensadorDeCedulas = new DispensadorDeCedulas(valor);
            SaqueBuilder saqueBuilder = dispensadorDeCedulas.obtemResultadoSaque();

            Transacao transacao = TransacaoBuilder.construirTransacaoDeSaque(saqueBuilder);
            TransacaoService transacaoService = TransacaoFactory.getInstance();

            transacaoService.inserirTransacao(transacao);

            List<Transacao> transacoes = transacaoService.listarTransacoesPorDataDecrescente(TipoOperacao.SAQUE);
            Map<Cedulas, Integer> todasCedulas = transacaoService.obterQtdTotalDeCedulasSacadas();
            System.out.println(todasCedulas);

            Integer media = transacaoService.obterMediaDoValorSacado();
            System.out.println(media);
            //printTransacoes(transacoes);
//            transacaoService.
            // inserir transacoes de saque com a qtd de cedulas entregues, data e hora da transacao
            redirecionaFluxo = false;
        }

    }

    private static void printTransacoes(List<Transacao> transacoes) {
        System.out.println("\n==================== Impressão de Transações ==================");

        for(Transacao transacao :transacoes) {
            System.out.println("");
            System.out.println("Data da Transação: " + transacao.getDataTransacao());
            System.out.println("Valor da Transação: " + transacao.getValor());
            System.out.println("Notas: " + transacao.getSaque().getQtdDeCedulas());
            System.out.println("");
        }

        System.out.println("================================================================");
    }
}
