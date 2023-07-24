package com.github.christianebs.banco.app;

import com.github.christianebs.banco.modelo.Conta;
import com.github.christianebs.banco.modelo.Pessoa;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Maria da Silva");
        titular1.setDocumento("123456789-12");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("José de Souza");
        titular2.setDocumento("987654321-98");

        Conta minhaConta = new Conta(titular1, 001, 100);
        Conta suaConta = new Conta(titular2, 001, 200);

        minhaConta.depositar(10_000);
        minhaConta.sacar(1_000, 10);

        suaConta.depositar(20_000);

        System.out.println("Tiular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Tiular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());

    }

}
