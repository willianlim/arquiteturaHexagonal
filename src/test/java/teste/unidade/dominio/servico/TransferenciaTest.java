package teste.unidade.dominio.servico;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import conta.sistema.dominio.servico.Transferencia;

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
    @DisplayName("Valor nulo como obrigatório.")
    void teste1() {
        try {
            transferencia.transferencia(null, contaDebito, contaCredito);
            fail("Valor tranferência obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor da transferência é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("conta débito como obrigatório.")
    void teste2() {
        try {
            transferencia.transferencia(vinte, null, contaCredito);
            fail("conta debito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Conta débito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("conta crédito como obrigatório.")
    void teste3() {
        try {
            transferencia.transferencia(vinte, contaDebito, null);
            fail("conta crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Conta crédito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("tranferir 20 reais.")
    void teste4() {
        try {
            transferencia.transferencia(vinte, contaDebito, contaCredito);
            assertEquals(contaDebito.getSaldo(), cem.subtract(vinte), "Saldo da conta debito deve bater");
            assertEquals(contaCredito.getSaldo(), cem.add(vinte), "Saldo de conta crédito deve bater");
        } catch (NegocioException exception) {
            fail("Deve tranferir com sucesso");
        }
    }
}