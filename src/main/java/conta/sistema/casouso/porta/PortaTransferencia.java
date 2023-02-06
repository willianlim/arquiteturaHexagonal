package conta.sistema.casouso.porta;

import conta.sistema.dominio.modelo.Conta;

import java.math.BigDecimal;

public interface PortaTransferencia {

    Conta getConta(Integer numero);
    void transferencia(Integer contaDebito, Integer contaCredito, BigDecimal valor);
}
