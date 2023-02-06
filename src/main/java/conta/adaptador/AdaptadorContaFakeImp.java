package conta.adaptador;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.porta.ContaRepositorio;

public class AdaptadorContaFakeImp implements ContaRepositorio {

    @Override
    public Conta get(Integer numero) {
        return null;
    }

    @Override
    public void alterar(Conta conta) {

    }
}
