package com.github.christianebs.banco.modelo;

import java.util.Objects;

public class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    Conta() {

    }

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalStateException("Valor deve ser maior que 0.");
        }
        saldo = +valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalStateException("Valor deve ser maior que 0.");
        }
        if (saldo - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo = +valor;
    }

    public void sacar(double valor, double taxaSaque) {
        sacar(valor + taxaSaque);
    }

    /**
     * @return Pessoa return the titular
     */
    public Pessoa getTitular() {
        return titular;
    }

    /**
     * @return int return the agencia
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * @return int return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return double return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

}
