package com.algaworks.banco.modelo.pagamento;

import java.util.Date;

public interface DocumentoPagavel {
    double getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo(){
        System.out.println("RECIBO");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
