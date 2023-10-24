public class ContaPoupanca extends Conta {
    public ContaPoupanca(String number, String agencyNumber, Client client, double balance, Transacao transacoes) {
        super(number, agencyNumber, client, balance, transacoes);
    }

    @Override
    public void depositar(double deposit) {
        if (deposit > 0) {
            double rendimentoDeposito = deposit + (deposit * 0.1);
            super.balance += rendimentoDeposito;
            getNotificacao().enviarNotificacao(deposit, "Depósito");
            getTransacoes().add(new Transacao(deposit, "Depósito"));
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
