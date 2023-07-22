package com.algaworks.banco.modelo;

public class ContaEspecial extends Conta{
    private double valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, double valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        //valor da tarifa mensal para conta tipo especial
        sacar(20);
    }

    @Override
    public double getSaldoDisponivel() {
        return super.getSaldo() + getValorLimite();
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }
}
