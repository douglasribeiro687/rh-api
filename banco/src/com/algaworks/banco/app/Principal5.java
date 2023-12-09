package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.pagamento.Banco;

import java.math.BigDecimal;
import java.util.Optional;

public class Principal5 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        //retorna saldo de uma conta, caso não exista retorna ZERO;
        BigDecimal saldo = banco.buscar(2, 222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);

        //retornando excecao caso nao encontrado;
        Conta contaEncontrada = banco.buscar(1, 222).
                orElseThrow(() -> new RuntimeException("Conta não encontrada!!!"));

        System.out.println("Valor Saldo: " + contaEncontrada.getSaldo());

        //mais melhor de bom
//        banco.buscar(1, 222).
//                ifPresent(conta -> System.out.println(conta.getSaldo()));

        //mais simples com lambida
//        Optional<Conta> contaOptional = banco.buscar(1, 222 );
//        contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }

    }
}
