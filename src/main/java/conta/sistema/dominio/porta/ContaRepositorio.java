package conta.sistema.dominio.porta;

import conta.sistema.dominio.modelo.Conta;

public interface ContaRepositorio {

    Conta get(Integer numero);
    void alterar(Conta conta);
}
