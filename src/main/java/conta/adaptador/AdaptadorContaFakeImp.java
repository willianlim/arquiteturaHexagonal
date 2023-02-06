package conta.adaptador;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import conta.sistema.dominio.porta.ContaRepositorio;

import javax.inject.Named;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.compare;
import static java.util.Objects.isNull;

@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {

    private Map<Integer, Conta> banco = new HashMap<>();

    @Override
    public Conta get(Integer numero) {
        System.out.println("Fake banco de dados -> Conta get(Integer numero)");
        return banco.get(numero);
    }

    @Override
    public void alterar(Conta conta) {
        System.out.println("Fake banco de dados -> alterar(alterar)");
        var ct = banco.get(conta.getNumero());

        if (!isNull(ct)) {
            banco.put(conta.getNumero(), conta);
        } else {
            throw new NegocioException("Conta inexistente");
        }
    }
}
