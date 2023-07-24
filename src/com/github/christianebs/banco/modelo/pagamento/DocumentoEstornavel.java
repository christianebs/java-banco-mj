package com.github.christianebs.banco.modelo.pagamento;

public interface DocumentoEstornavel extends DocumentoPagavel {
    
    void estornarPagamento();
}
