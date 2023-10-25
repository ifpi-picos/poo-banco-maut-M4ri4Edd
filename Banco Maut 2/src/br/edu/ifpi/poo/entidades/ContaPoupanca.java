package br.edu.ifpi.poo.entidades;

import br.edu.ifpi.poo.notificações.Notificacao;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String number, String agencyNumber, Client client, double balance, Transacao transacoes, Notificacao notificacao) {
        super(number, agencyNumber, client, balance, transacoes, notificacao);
    }

     public Notificacao getNotificacao() {
       return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public void depositar(double deposit) {
        if (deposit > 0) {
            double rendimentoDeposito = deposit + (deposit * 0.1);
            setBalance(balance += rendimentoDeposito);
            getNotificacao().enviarNotificacao(deposit, "Depósito na Conta Poupança");
            System.out.println("Depósito realizado com sucesso");
            getTransacoes().add(new Transacao(deposit, "Depósito na conta Poupança"));
        } else{
            System.out.println("Depósito inválido!");
        }
    }

    @Override
    public void Sacar(double saque){
        double valorTaxado = saque + (saque * 0.05);
        if (valorTaxado <= balance){
            setBalance(balance -= valorTaxado);
            System.out.println("Saque realizado com sucesso");
            getNotificacao().enviarNotificacao(saque, "Saque da Conta Poupança");
            getTransacoes().add(new Transacao(saque, "Saque da Conta Poupança"));
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    @Override
    public void Transferir(double transferencia){
        double valorTaxado = transferencia + (transferencia * 0.05);
        if (transferencia <= valorTaxado){
            setBalance(balance -= valorTaxado);;
            System.out.println("Transferência realizada com sucesso!");
            getNotificacao().enviarNotificacao(transferencia, "Transferência da Conta Poupança");
            getTransacoes().add(new Transacao(transferencia, "Transferência da Conta Poupança"));
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }
}
