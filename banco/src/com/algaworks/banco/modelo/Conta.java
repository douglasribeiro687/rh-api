package com.algaworks.banco.modelo;

import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta(){
    }
    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que zero!!!");

        }
        saldo = saldo.add(valor);
    }

    public void sacar (BigDecimal valor){
        if ( valor.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que Zero!!!");
        }

        if ( getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("saldo insuficiente!!!");
        }

        saldo = saldo.subtract(valor);
    }

    public abstract void debitarTarifaMensal();

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }

    public void sacar (BigDecimal valor, BigDecimal taxaSacar){
        sacar(valor.add(taxaSacar));
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
