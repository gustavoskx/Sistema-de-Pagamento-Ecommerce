package service;

public class Pix extends PagamentoBase{
    private String instituicaoFinanceira;
    private String numeroTrasacao;

    public Pix(double valor, String data, Cliente cliente, String instituicaoFinanceira, String numeroTrasacao) {
        super(valor, data, cliente);
        setInstituicaoFinanceira(instituicaoFinanceira);
        setNumeroTrasacao(numeroTrasacao);
    }

    @Override
    public boolean validarPagamento() {

        if (instituicaoFinanceira == null || instituicaoFinanceira.trim().isEmpty()) {
            System.out.println("Instituição financeira não pode ser vazia!");
            return false;
        }

        if (numeroTrasacao == null || numeroTrasacao.trim().isEmpty()) {
            System.out.println("Número da transação não pode ser vazio!");
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
            System.out.println("Instituição financeira: " + this.instituicaoFinanceira);
            System.out.println("Número da transação: " + this.numeroTrasacao);
        }else{
            System.out.println("Recibo não emitido!");
        }
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        if (instituicaoFinanceira != null && !instituicaoFinanceira.trim().isEmpty()) {
            this.instituicaoFinanceira = instituicaoFinanceira;
        }else{
            System.out.println("Instituição financeira não pode ser nula ou vazia!");
        }
    }

    public String getNumeroTrasacao() {
        return numeroTrasacao;
    }

    public void setNumeroTrasacao(String numeroTrasacao) {
        if (numeroTrasacao != null && !numeroTrasacao.trim().isEmpty()) {
            this.numeroTrasacao = numeroTrasacao;
        }else{
            System.out.println("Número da transação não pode ser nulo ou vazio!");
        }
    }
}
