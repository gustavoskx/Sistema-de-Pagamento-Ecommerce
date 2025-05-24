package service;

public abstract class PagamentoBase implements Pagamento{
    protected double valor;
    protected String data;
    protected Cliente cliente;

    public PagamentoBase(double valor, String data, Cliente cliente) {
        setValor(valor);
        setData(data);
        setCliente(cliente);
    }

    @Override
    public abstract boolean validarPagamento();

    @Override
    public abstract void realizarPagamento();

    @Override
    public void emitirRecibo(){
        System.out.println("Emitindo recibo de pagamento...");
        System.out.println("Valor: " + this.valor);
        System.out.println("Data: " + this.data);
        System.out.println("Cliente: " + this.cliente.getNome());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        } else {
            System.out.println("Cliente não pode ser nulo!");
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (data != null && !data.trim().isEmpty()) {
            this.data = data;
        }else{
            System.out.println("Data não pode ser nula ou vazia!");
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        }
    }
}
