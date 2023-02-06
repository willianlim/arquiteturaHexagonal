package conta.sistema.dominio.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

@DisplayName("Regra de Débito de Conta.")
public class TesteDebitoConta {

    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach
    void setUp() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("Valor débito nulo como obrigatório.")
    void teste1() {
        try {
            contaValida.debitar(null);
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor débito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor débito negativo como obrigatório.")
    void teste2() {
        try {
            contaValida.debitar(new BigDecimal(-10));
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor débito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor débito zero como obrigatório.")
    void teste3() {
        try {
            contaValida.debitar(BigDecimal.ZERO);
//            fail("Valor crédito obrigatório");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Valor débito é obrigatório.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor débito acima do saldo.")
    void teste4() {
        try {
            contaValida.debitar(cem.add(BigDecimal.ONE));
            fail("Valor débito acima do saldo.");
        } catch (NegocioException exception) {
            assertEquals(exception.getMessage(), "Saldo insulficiente.");
            System.out.println(exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor débito igual ao saldo.")
    void teste5() {
        try {
            contaValida.debitar(cem);
            assertEquals(contaValida.getSaldo(), BigDecimal.ZERO, "Saldo deve zerar.");
        } catch (NegocioException exception) {
            fail("Deve debitar com sucesso - " + exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valor débito menor do saldo.")
    void teste6() {
        try {
            contaValida.debitar(BigDecimal.TEN);
            var contaFinal = cem.subtract(BigDecimal.TEN);
            assertEquals(contaValida.getSaldo(), contaFinal, "Saldo deve bater.");
        } catch (NegocioException exception) {
            fail("Deve debitar com sucesso - " + exception.getMessage());
        }
    }
}