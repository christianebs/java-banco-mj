package com.github.christianebs.banco.app;

import java.util.function.ToIntFunction;

import com.github.christianebs.banco.modelo.Conta;

public class NumeroContaFunction implements ToIntFunction<Conta> {
    
    @Override
    public int applyAsInt(Conta conta) {
        return conta.getNumero();
    }
}
