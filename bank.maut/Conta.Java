package bank.maut;

public class Conta {
    private String number;
    private String agencyNumber;
    private String client;
    private double balance;
    private List<Transacao> transacoes = new ArrayList<Transacao>();;

    public Conta(String number, String agencyNumber, String client, double balance, String history){
        this.number = number;
        this.agencyNumber = agencyNumber;
        this.client = client;
        this.balance = balance;
    }

    public String getNumber{
        return number;
    }

    public String getAgencyNumber{
        return agencyNumber;
    }

    public String getClient{
        return client;
    }

    public String getBalance{
        return balance;
    }
}