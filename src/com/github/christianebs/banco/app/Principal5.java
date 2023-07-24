package com.github.christianebs.banco.app;

import java.math.BigDecimal;

import com.github.christianebs.banco.modelo.Banco;
import com.github.christianebs.banco.modelo.Conta;

public class Principal5 {

    public static void main(String[] args) {
    
    Banco banco = new Banco();

//        Optional<Conta> contaOptional = banco.buscar(002, 202);

//        banco.buscar(002, 202)
//                .ifPresent(conta -> System.out.println(conta.getSaldo()));

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }

//        Conta contaEncontrada = banco.buscar(002, 203)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada."));
//
//        System.out.println(contaEncontrada.getSaldo());

        BigDecimal saldo = banco.buscar(002, 203)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
        

    }
}