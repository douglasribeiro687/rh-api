package com.algaworks.banco.app;

import java.math.BigDecimal;

public class TesteCalculo {

    public static void main(String[] args) {
        // demonstra ponto flutuando no resultado x = 0.39999999999999997
//        double x = 1.0;
//        x = x - .10;
//        x = x - .20;
//        x = x - .30;
//        System.out.println("x = " + x);

        // Usamos quando é necessario ter total precisao de valores
        BigDecimal x = new BigDecimal("1.0");
        x = x.subtract(new BigDecimal("0.10"));
        x = x.subtract(new BigDecimal("0.20"));
        x = x.subtract(new BigDecimal("0.30"));

        System.out.println("x = " + x);
    }
}
