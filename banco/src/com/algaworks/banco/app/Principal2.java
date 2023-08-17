package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Pessoa;

import java.util.HashSet;
import java.util.Set;

public class Principal2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Douglas Ribeiro", "123.123.123-99");
        Pessoa pessoa2 = new Pessoa("Rafael Oliveira", "999.123.123-99");
        Pessoa pessoa3 = new Pessoa("Luisa Oliveira", "999.123.123-77");

        // Listas
//        List<Pessoa> pessoas = new ArrayList<>();

        // conjuntos
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        System.out.println(pessoas);

//        for (int i = 0; i < pessoas.size(); i++) {
//            System.out.println(pessoas.get(i).getNome());
//        }

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.getNome());
        }

        // verificar se contem na lista
        Pessoa pessoa4 = new Pessoa("Daiane Lopes", "999.123.123-22");

        boolean existe = pessoas.contains(pessoa3);
        System.out.println("Pessoa 3 esta contindo na lista de pessoas: " + existe);

        existe = pessoas.contains(pessoa4);
        System.out.println("Pessoa 4 esta contindo na lista de pessoas: " + existe);

        System.out.println("Testar se pessoa2 é igual a pessoa 3: " + pessoa2.equals(pessoa3));

        // implem de conjuntos classe collections


    }
}
