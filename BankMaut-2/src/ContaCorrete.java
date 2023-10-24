public class ContaCorrete extends Conta {
    private double chequeEspecial;
    private int transferenciasRestantes;

    public ContaCorrete(String number, String agencyNumber, Client client, double balance, Transacao transacoes) {
        super(number, agencyNumber, client, balance, transacoes);
        this.chequeEspecial = 1000;
        this.transferenciasRestantes = 1;
      }

    public double getChequeEspecial() {
        return super.balance + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.getBalance();
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
            } else if(transferenciasRestantes > 0 && transferenciasRestantes <= 2){
                setBalance(balance -= transferencia);
                getNotificacao().enviarNotificacao(transferencia, "Transferência da Conta Corrente");
                getTransacoes().add(new Transacao(transferencia, "Transferência da Conta Corrente"));
            }
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }

}
