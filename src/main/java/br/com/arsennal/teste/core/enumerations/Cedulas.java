package br.com.arsennal.teste.core.enumerations;

/**
 * Created by wesley_kenji on 06/02/16.
 */
public enum Cedulas {

    NOTA_100(100),
    NOTA_50(50),
    NOTA_20(20),
    NOTA_10(10),
    NOTA_5(5),
    NOTA_2(2);

    Cedulas(Integer valor) {
        this.valor = valor;
    }

    private final Integer valor;

    public Integer getValor() {
        return valor;
    }

}
