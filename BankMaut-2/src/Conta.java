import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String number;
    private String agencyNumber;
    private String client;
    protected double balance;
    private List<Transacao> transacoes = new ArrayList<Transacao>();
    private Notificacao notificacao;

    public Conta(String number, String agencyNumber, String client, double balance, Transacao transacoes){
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

   public String getClient() {
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
        } else{
            System.out.println("Depósito Inválido");
        }
    }

    public void Sacar(double saque){
        if (saque <= balance){
            setBalance(balance -= saque);
            System.out.println("Saque realizado com sucesso");
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void Transferir(double transferencia){
        if (transferencia <= balance){
            setBalance(balance -= transferencia);;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }

    public void adicionarTransacao(double value, String type){
        Transacao novaTransacao = new Transacao(value, type);
        transacoes.add(novaTransacao);
    }
    public void verExtrato(){
        for(Transacao novaTransacao : transacoes){
            System.out.println(novaTransacao.toString());
        }
    }

}

