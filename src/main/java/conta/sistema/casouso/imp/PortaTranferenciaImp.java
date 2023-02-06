package conta.sistema.casouso.imp;

import conta.sistema.casouso.porta.PortaTransferencia;
import conta.sistema.dominio.modelo.Conta;

import java.math.BigDecimal;

public class PortaTranferenciaImp implements PortaTransferencia {

    @Override
    public Conta getConta(Integer numero) {
        return null;
    }

    @Override
    public void transferencia(Integer contaDebito, Integer contaCredito, BigDecimal valor) {

    }
}
