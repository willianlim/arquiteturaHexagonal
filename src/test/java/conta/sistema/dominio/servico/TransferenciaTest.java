package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciaTest {

    BigDecimal cem = new BigDecimal(100);
    BigDecimal vinte = new BigDecimal(20);
    Transferencia transferencia;
    Conta contaDebito;
    Conta contaCredito;

    @BeforeEach
    void setUp() {
        contaDebito = new Conta(1, cem, "Fernando");
        contaCredito = new Conta(2, cem, "Rebeca");
        transferencia = new Transferencia();
    }

    @Test
    void transferencia() {
    }
}