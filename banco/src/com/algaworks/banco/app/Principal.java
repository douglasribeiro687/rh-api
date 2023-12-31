package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Douglas Ribeiro teste ");
        titular1.setDocumento("123.123.123-99");
        titular1.setRendimentoAnual(new BigDecimal(("15000")));

        Pessoa titular2 = new Pessoa();
        titular2.setNome("João da Silva");
        titular2.setDocumento("999.999.999-99");

        // alterando data
        titular2.setDataUltAtualizacao(LocalDateTime.parse("2023-07-21T18:54"));

        System.out.println("Data: " + titular2.getDataUltAtualizacao());

        try {

            ContaInvestimento minhaConta = new ContaInvestimento(titular1, 0001, 1020);
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"), new BigDecimal("5"));
            minhaConta.creditarRendimentos(new BigDecimal("0.08"));
            minhaConta.debitarTarifaMensal();

            ContaEspecial suaConta = new ContaEspecial(titular2, 0002, 999, new BigDecimal("1000"));
            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular1, new BigDecimal("200"));
            Holerite salarioFuncionario = new Holerite(titular1, new BigDecimal("55"), 163);

            // exemplo de polimorfismo - impressão de dados da classe Conta
            CaixaEletronico caixaEletronico = new CaixaEletronico();
            caixaEletronico.pagar(boletoEscola, minhaConta);
//        boletoEscola.imprimirRecibo();
            caixaEletronico.estornar(boletoEscola, minhaConta);

            System.out.println("Boleto pago: " + boletoEscola.estaPago());

            caixaEletronico.pagar(salarioFuncionario, minhaConta);
//        salarioFuncionario.imprimirRecibo();
            System.out.println("Holerite pago: " + salarioFuncionario.estaPago());

            caixaEletronico.imprimirSaldo(minhaConta);
            System.out.println();
            caixaEletronico.imprimirSaldo(suaConta);

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

//        System.out.println("Titular: " + minhaConta.getTitular().getNome());
//        System.out.println("Saldo: " + minhaConta.getSaldo());
//
//        System.out.println("Titular: " + suaConta.getTitular().getNome());
//        System.out.println("Saldo: " + suaConta.getSaldo());
    }
}
