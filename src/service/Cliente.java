package service;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private List<PagamentoBase> pagamentos;

    public Cliente(String nome, String cpf, String email) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        this.pagamentos = new ArrayList<>();
    }

    public void listaPagamento(){
        System.out.println("Lista de pagamentos de " + this.nome + ":");
        for (PagamentoBase pagamento : pagamentos) {
            System.out.println("-----------------------------------");
            pagamento.emitirRecibo();
            System.out.println("-----------------------------------");
        }
    }

    public void adicionarPagamento(PagamentoBase pagamento) {
        if (pagamento != null) {
            this.pagamentos.add(pagamento);
        }
    }

    public List<PagamentoBase> getPagamentos() {
        return this.pagamentos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.trim().isEmpty()) {
            this.cpf = cpf;
        }else{
            System.out.println("CPF não pode ser nulo ou vazio!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        }else{
            System.out.println("Email não pode ser nulo ou vazio!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }else{
            System.out.println("Nome não pode ser nulo ou vazio!");
        }
    }
}
