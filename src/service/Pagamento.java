package service;

public interface Pagamento {
    boolean validarPagamento();
    void realizarPagamento();
    void emitirRecibo();
}
