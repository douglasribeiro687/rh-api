package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.pagamento.Banco;

import java.util.Comparator;

public class Principal3 {
    public static void main(String[] args) {

        Banco banco = new Banco();

        //Expressao lambida para ordendar as contas dentro da lista de contas;
        //banco.getContas().sort(Comparator.comparingInt((Conta conta) -> conta.getNumero()));

        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for (Conta contas : banco.getContas()){
            System.out.println(contas.getAgencia() + " / " + contas.getNumero());
        }

    }
}
