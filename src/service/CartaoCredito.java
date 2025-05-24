package service;

public class CartaoCredito extends PagamentoBase{
    private String numeroCartao;
    private String dataValidade;
    private String nomeTitular;

    public CartaoCredito(double valor, String data, Cliente cliente,
                         String dataValidade, String nomeTitular, String numeroCartao) {
        super(valor, data, cliente);
        setDataValidade(dataValidade);
        setNomeTitular(nomeTitular);
        setNumeroCartao(numeroCartao);
    }

    @Override
    public boolean validarPagamento() {
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            System.out.println("Número do cartão inválido!");
            return false;
        }

        if (dataValidade == null || !dataValidade.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            System.out.println("Data de validade inválida!");
            return false;
        }

        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            System.out.println("O nome do titular do cartão é inválido!");
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
        if(validarPagamento()){
            super.emitirRecibo();
            System.out.println("Nome do titular: " + this.nomeTitular);
            System.out.println("Numero do cartão: " + getNumeroCartao());
            System.out.println("Data de validade: " + this.dataValidade);
        }else{
            System.out.println("Recibo não emitido!");
        }
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        if (dataValidade != null && !dataValidade.trim().isEmpty()) {
            this.dataValidade = dataValidade;
        }else{
            System.out.println("Data de validade não pode ser nula ou vazia!");
        }
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        if (nomeTitular != null && !nomeTitular.trim().isEmpty()) {
            this.nomeTitular = nomeTitular;
        }else{
            System.out.println("Nome do titular não pode ser nulo ou vazio!");
        }
    }

    public String getNumeroCartao() {
            return "**** **** **** " + numeroCartao.substring(numeroCartao.length() - 4);
    }

    public void setNumeroCartao(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.trim().isEmpty()) {
            System.out.println("Numero do cartao não pode ser nulo ou vazio!");
            return;
        }

        if (numeroCartao.matches("[0-9]{16}")) {
            this.numeroCartao = numeroCartao;
        }else{
            System.out.println("Numero do cartao deve ter 16 digitos!");
        }
    }
}
