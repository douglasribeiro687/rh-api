package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Douglas Ribeiro", "123.123.123-99");
        Pessoa pessoa2 = new Pessoa("Rafael Oliveira", "999.123.123-99");

        // Listas
//        List<Pessoa> pessoas = new ArrayList<>();

        // conjuntos
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas);

//        for (int i = 0; i < pessoas.size(); i++) {
//            System.out.println(pessoas.get(i).getNome());
//        }

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.getNome());
        }

        // verificar se contem na lista
        Pessoa pessoa3 = new Pessoa("Rafael Oliveira", "999.123.123-99");

        boolean existe = pessoas.contains(pessoa3);
        System.out.println(existe);

        System.out.println(pessoa2.equals(pessoa3));

        // implem de conjuntos classe collections


    }
}
