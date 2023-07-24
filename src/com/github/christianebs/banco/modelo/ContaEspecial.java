package com.github.christianebs.banco.modelo;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {

    private BigDecimal valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, BigDecimal valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(new BigDecimal("20"));
    }
    
    @Override
    public BigDecimal getSaldoDisponivel() {
        return getSaldo().add(getValorLimite());
    }

    /**
     * @return double return the valorLimite
     */
    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    /**
     * @param valorLimite the valorLimite to set
     */
    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

}
