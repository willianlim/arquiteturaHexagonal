// Responsável por definir as regras de visibilidade do modulo sistema.
module conta.sistema {
    // usa spring
    requires javax.inject;
    requires spring.tx;

    // expondo porta de entrada (driver)

    exports conta.sistema.casouso.imp;

    // expondo sistema negocio

    exports conta.sistema.dominio.servico;

    // expondo adaptadores de saídas (driven)

    exports conta.adaptador;
}