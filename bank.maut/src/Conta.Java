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

 public static void showBalance(){
        System.out.println("Agencia: " + this.agencyNumber);
        System.out.println("Conta: " + this.number);
        System.out.println("Saldo: R$ " + this.balance);
    }

    public void deposit(float depositAmount){
        System.out.println("Digite o valor a ser depositado:");
        double depositAmount = Scanner.nextDouble();
        balance += depositAmount;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void withdraw(float withdrawAmount){
        System.out.println("Digite o valor a ser sacado:");
        double withdrawAmount = Scanner.nextDouble();
        if (withdrawAmount <= balance){
            balance -= withdrawAmount
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void transfer(float transferAmount){
        System.out.println("Digite o valor a ser transferido:");
        double withdrawAmount = Scanner.nextDouble();
        System.out.println("Digite o nome do destinatário:");
        String destinatario = scanner.next();
        System.out.println("Digite o número da conta de destino:");
        String contaDestino = scanner.next();
        if (transferAmount <= balance){
            balance -= transferAmount;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Tranferência Interrompida: Saldo Insuficiente.");
        }
    }

}
