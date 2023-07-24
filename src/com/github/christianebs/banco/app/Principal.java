package com.github.christianebs.banco.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.christianebs.banco.modelo.ContaEspecial;
import com.github.christianebs.banco.modelo.ContaInvestimento;
import com.github.christianebs.banco.modelo.Pessoa;
import com.github.christianebs.banco.modelo.TipoPessoa;
import com.github.christianebs.banco.modelo.atm.CaixaEletronico;
import com.github.christianebs.banco.modelo.excecao.SaldoInsuficienteException;
import com.github.christianebs.banco.modelo.pagamento.Boleto;
import com.github.christianebs.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Maria da Silva");
        titular1.setDocumento("123456789-12");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-07-24T03:16:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("José de Souza");
        titular2.setDocumento("987654321-98");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 001, 100);
        ContaEspecial suaConta = new ContaEspecial(titular2, 001, 200, new BigDecimal("1000"));

        try {

            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("");
        caixaEletronico.imprimirSaldo(suaConta);

    }

}
