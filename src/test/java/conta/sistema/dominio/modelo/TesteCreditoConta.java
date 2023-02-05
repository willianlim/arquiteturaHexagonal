package conta.sistema.dominio.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

@DisplayName("Regra de Crédito de Conta.")
public class TesteCreditoConta {

    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach
    void setUp() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("Valor crédito nulo como obrigatório.")
    void teste1() {
        try {
            contaValida.creditar(null);
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor crédito negativo como obrigatório.")
    void teste2() {
        try {
            contaValida.creditar(new BigDecimal(-10));
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor crédito zero como obrigatório.")
    void teste3() {
        try {
            contaValida.creditar(new BigDecimal(0));
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor crédito acima de zero.")
    void teste4() {
        try {
            contaValida.creditar(BigDecimal.ONE);
            var saldoFinal = cem.add(BigDecimal.ONE);
            assertEquals(contaValida.getSaldo(), saldoFinal, "Saldo deve bater");
        } catch (NegocioException exception) {
            fail("Deve creditar com sucesso - " + exception.getMessage());
        }
    }
}