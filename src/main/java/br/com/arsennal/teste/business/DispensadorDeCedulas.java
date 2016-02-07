package br.com.arsennal.teste.business;

import br.com.arsennal.teste.core.builder.SaqueBuilder;
import br.com.arsennal.teste.core.enumerations.Cedulas;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public class DispensadorDeCedulas {

    private SaqueBuilder saqueBuilder;
    private Integer valorRestante;

    public DispensadorDeCedulas(final Integer valorOriginal) {
        saqueBuilder = new SaqueBuilder(valorOriginal);
        this.valorRestante = valorOriginal;

        for(Cedulas cedula : Cedulas.values()) {
            divideValorPorTipoDeCedula(cedula, valorRestante);
        }
    }

    public DispensadorDeCedulas(final Integer valorOriginal, Boolean validacao) {
        if(validacao == false){ return; }

        this.valorRestante = valorOriginal;

        for(Cedulas cedula : Cedulas.values()) {
            divideValorPorTipoDeCedulaParaValidacao(cedula, valorRestante);
        }
    }

    private void divideValorPorTipoDeCedula(Cedulas cedula, Integer valorRestante) {
//        System.out.println("====================  INICIO  ===========================");
//        System.out.println("Valor atual: " + valorRestante);
//        System.out.println("Cedula de : " + cedula);
        Integer qtdCedula = 0;

        if(valorRestante >= cedula.getValor()){
            qtdCedula = valorRestante / cedula.getValor();
            this.valorRestante = valorRestante % cedula.getValor();
        }

        saqueBuilder.addCedulas(qtdCedula, cedula);

//        System.out.println("Valor atual: " + valorRestante);
//        System.out.println("Qtd de cedula cedida : " + qtdCedula);
//        System.out.println("====================  FIM  ===========================");

    }

    private void divideValorPorTipoDeCedulaParaValidacao(Cedulas cedula, Integer valorRestante) {

        if(valorRestante >= cedula.getValor()){
            this.valorRestante = valorRestante % cedula.getValor();
        }

    }

    public SaqueBuilder obtemResultadoSaque(){
        return saqueBuilder;
    }

    public Integer obtemValorRestante() {
        return this.valorRestante;
    }
}
