package service;

public class Boleto extends PagamentoBase{
    private String numeroBoleto;
    private String dataVencimento;
    private String codigoBarras;

    public Boleto(double valor, String data, Cliente cliente, String dataVencimento, String codigoBarras, String numeroBoleto) {
        super(valor, data, cliente);
        setDataVencimento(dataVencimento);
        setCodigoBarras(codigoBarras);
        setNumeroBoleto(numeroBoleto);
    }

    @Override
    public boolean validarPagamento() {
        if (numeroBoleto == null || !(numeroBoleto.length() == 47 || numeroBoleto.length() == 48)) {
            System.out.println("Número do boleto inválido!");
            return false;
        }

        if (dataVencimento == null || dataVencimento.trim().isEmpty()) {
            System.out.println("A data de vencimento é inválida!");
            return false;
        }

        return true;
    }

    @Override
    public void realizarPagamento() {
        if (validarPagamento()) {
            cliente.adicionarPagamento(this);
            System.out.println("Realizando pagamento...");
            System.out.println("Pagamento efetuado com sucesso!");
        }else{
            System.out.println("Pagamento não efetuado!");
        }
    }

    @Override
    public void emitirRecibo() {
        if (validarPagamento()) {
            super.emitirRecibo();
            System.out.println("Numero do boleto: " + this.numeroBoleto);
            System.out.println("Data de vencimento: " + this.dataVencimento);
            System.out.println("Codigo de barras: " + this.codigoBarras);
        }else{
            System.out.println("Recibo não emitido!");
        }
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        if (codigoBarras != null && !codigoBarras.trim().isEmpty()) {
            this.codigoBarras = codigoBarras;
        }else{
            System.out.println("Código de barras não pode ser nulo ou vazio!");
        }
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        if (dataVencimento != null && !dataVencimento.trim().isEmpty()) {
            this.dataVencimento = dataVencimento;
        }else{
            System.out.println("Data de vencimento não pode ser nula ou vazia!");
        }
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        if (numeroBoleto != null && !numeroBoleto.trim().isEmpty()) {
            this.numeroBoleto = numeroBoleto;
        }else{
            System.out.println("Número do boleto não pode ser nulo ou vazio!");
        }
    }
}
