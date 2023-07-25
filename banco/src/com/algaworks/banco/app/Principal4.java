package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;
import com.algaworks.banco.modelo.pagamento.Banco;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {

        Banco banco = new Banco();

        //lista de titulares das contas

        List<Pessoa> titulares = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(titulares);

        //somar total de saldo de todas as contas;
        BigDecimal valorSaldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Saldo total banco: " + valorSaldoTotal);

        // codigo inchuto
        banco.getContas().stream()
                .filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("0")) > 0)
                .filter(conta -> conta.getNumero() > 0)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .map(Conta::getTitular)
                .distinct()
                .forEach(System.out::println);

//        banco.getContas().stream()
//                .filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("0")) > 0)
//                .filter(conta -> conta.getNumero() > 0)
//                .sorted(Comparator.comparingInt(Conta::getNumero))
//                .forEach(conta -> {
//                    conta.depositar(new BigDecimal("10"));
//                    System.out.println(conta.getAgencia() + " / " + conta.getNumero()
//                            + " -> Saldo: " + conta.getSaldoDisponivel());
//                });

//        Stream<Conta> stream = banco.getContas().stream();
//        //stream com filtro
//        Stream<Conta> stream2 = stream.filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("299")) > 0);
//
//        //usando stream para filtrar informacoes dentro da lista
//        //stream.filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("300")) > 0);
//
//        stream2.forEach(conta -> {
//            conta.depositar(new BigDecimal("10"));
//            System.out.println(conta.getAgencia() + " / " + conta.getNumero()
//            + " -> Saldo: " + conta.getSaldoDisponivel());
//        });

//        streamFiltro.forEach(conta -> System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " Saldo:" + conta.getSaldoDisponivel()));
    }
}
