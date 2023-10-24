import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String number;
    private String agencyNumber;
    private Client client;
    protected double balance;
    private List<Transacao> transacoes = new ArrayList<Transacao>();
    private Notificacao notificacao;

    public Conta(String number, String agencyNumber, Client client, double balance, Transacao transacoes){
        this.number = number;
        this.agencyNumber = agencyNumber;
        this.client = client;
        this.balance = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public String getNumber() {
       return number;
   }

   public String getAgencyNumber() {
       return agencyNumber;
   }

   public Client getClient() {
       return client;
   }

   public double getBalance() {
       return balance;
   }

   public List<Transacao> getTransacoes() {
       return transacoes;
   }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void depositar(double deposit){
        if (deposit > 0){
            setBalance(balance += deposit);
            System.out.println("Depósito realizado com sucesso");
            getTransacoes().add(new Transacao(deposit, "Depósito"));
        } else{
            System.out.println("Depósito Inválido");
        }
    }

    public void Sacar(double saque){
        if (saque <= balance){
            setBalance(balance -= saque);
            System.out.println("Saque realizado com sucesso");
            getTransacoes().add(new Transacao(saque, "Saque"));
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void Transferir(double transferencia){
        if (transferencia <= balance){
            setBalance(balance -= transferencia);;
            System.out.println("Transferência realizada com sucesso!");
            getTransacoes().add(new Transacao(transferencia, "Transferência"));
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }

    public void receberTransferencia(double transferencia){
        setBalance(balance += transferencia);
        getTransacoes().add(new Transacao(transferencia, "Transferência recebida"));
    }

    public void verExtrato(){
        for(Transacao novaTransacao : transacoes){
            System.out.println(novaTransacao.toString());
        }
    }

}
