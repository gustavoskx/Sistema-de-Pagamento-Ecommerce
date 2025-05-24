package service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("João Silva", "12345678900", "joao@email.com");

        PagamentoBase pagamentoCartao = new CartaoCredito(
                100.00, "2023-10-10", cliente, "12/25", "João Silva", "1234567812345678");

        PagamentoBase pagamentoBoleto = new Boleto(
                250.00, "2023-10-11", cliente, "2023-12-01", "12345678901234567890123456789012345678901234", null);

        PagamentoBase pagamentoPix = new Pix(
                50.00, "2023-10-10", cliente, "Banco XYZ", "0001");

        List<PagamentoBase> pagamentos = new ArrayList<>();
        pagamentos.add(pagamentoCartao);
        pagamentos.add(pagamentoBoleto);
        pagamentos.add(pagamentoPix);

        for (PagamentoBase pagamento : pagamentos) {
            System.out.println("\n--- Processando pagamento ---");
            pagamento.realizarPagamento();
            pagamento.emitirRecibo();
        }

        System.out.println();
        cliente.listaPagamento();

    }
}