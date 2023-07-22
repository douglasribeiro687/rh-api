package com.algaworks.banco.modelo;

import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;

import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    Conta(){
    }
    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar (double valor){
        if ( valor <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que Zero!!!");
        }

        if ( getSaldoDisponivel() - valor < 0) {
            throw new SaldoInsuficienteException("saldo insuficiente!!!");
        }

        saldo = saldo - valor;
    }

    public abstract void debitarTarifaMensal();

    public double getSaldoDisponivel(){
        return getSaldo();
    }

    public void sacar (double valor, double taxaSacar){
        sacar(valor+taxaSacar);;
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

    public double getSaldo() {
        return saldo;
    }

}
