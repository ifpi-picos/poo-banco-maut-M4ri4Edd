package br.edu.ifpi.poo.entidades;

import br.edu.ifpi.poo.notificações.Notificacao;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRestantes;

    public ContaCorrente(String number, String agencyNumber, Client client, double balance, Transacao transacoes, Notificacao notificacao) {
        super(number, agencyNumber, client, balance, transacoes, notificacao);
        this.chequeEspecial = 1000;
        this.transferenciasRestantes = 1;
      }

    public double getChequeEspecial() {
        return super.balance + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.getBalance();
    }

         public Notificacao getNotificacao() {
       return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public void Sacar(double saque){
        double valorCheque = getChequeEspecial();
        double divida = saque - balance;
        if (saque <= balance){
            setBalance(balance -= saque);
            System.out.println("Saque realizado com sucesso");
            getNotificacao().enviarNotificacao(saque, "Saque da Conta Corrente");
            getTransacoes().add(new Transacao(saque, "Saque da Conta Corrente"));
        } else if(saque > balance && saque < valorCheque){
            setBalance(balance -= saque);
            System.out.println("Saque realizado com sucesso!");
            System.out.println("O cliente deve ao banco R$ " + divida);
            getNotificacao().enviarNotificacao(saque, "Saque da Conta Corrente");
            getTransacoes().add(new Transacao(saque, "Saque da Conta Corrente"));
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    @Override
    public void Transferir(double transferencia){
        double valorTaxado = transferencia + (transferencia * 0.1);
        if (transferencia <= getChequeEspecial()){
            if(transferenciasRestantes > 2){
                setBalance(balance -= valorTaxado);;
                System.out.println("Transferência realizada com sucesso!");
                getNotificacao().enviarNotificacao(transferencia, "Transferência da Conta Corrente");
                getTransacoes().add(new Transacao(transferencia, "Transferência da Conta Corrente"));
                transferenciasRestantes++;
            } else if(transferenciasRestantes > 0 && transferenciasRestantes <= 2){
                setBalance(balance -= transferencia);
                getNotificacao().enviarNotificacao(transferencia, "Transferência da Conta Corrente");
                getTransacoes().add(new Transacao(transferencia, "Transferência da Conta Corrente"));
                transferenciasRestantes++;
            }
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }
}
