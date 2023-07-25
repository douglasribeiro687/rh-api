package com.algaworks.banco.modelo.pagamento;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.ContaEspecial;
import com.algaworks.banco.modelo.ContaInvestimento;
import com.algaworks.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public Banco() {
        Pessoa titular = new Pessoa("Nome 1", "999.999.999-99");
        Pessoa titular2 = new Pessoa("Nome 22", "999.999.999-91");
        Conta conta1 = new ContaInvestimento(titular, 1, 123);
        Conta conta2 = new ContaInvestimento(titular, 1, 125);
        Conta conta3 = new ContaInvestimento(titular, 1, 222);
        Conta conta4 = new ContaEspecial(titular2, 1, 22, new BigDecimal("1000"));

        conta1.depositar(new BigDecimal("100"));
        conta2.depositar(new BigDecimal("200"));
        conta3.depositar(new BigDecimal("300"));
        conta4.depositar(new BigDecimal("1000"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);

    }

    public List<Conta> getContas() {
        return contas;
    }

    //exempplo de retorno prevendo Optional
    public Optional<Conta> buscar (int agencia, int numero){
        for (Conta conta : getContas()){
            if (conta.getAgencia() == agencia && conta.getNumero() == numero){
                return Optional.of(conta);
            }

        }
        return Optional.empty();
    }

//    public Conta buscar (int agencia, int numero){
//        for (Conta conta : getContas()){
//            if (conta.getAgencia() == agencia && conta.getNumero() == numero){
//                return conta;
//            }
//
//        }
//        return null;
//    }

}
