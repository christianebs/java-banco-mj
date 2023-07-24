package com.github.christianebs.banco.modelo.pagamento;

import java.math.BigDecimal;

import com.github.christianebs.banco.modelo.Pessoa;

public class Holerite implements DocumentoPagavel {

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidadeHoras));
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
    
}
