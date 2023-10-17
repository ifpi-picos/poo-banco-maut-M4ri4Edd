import.java.until.Scanner;

public class Transacao{
    private double value;
    private String type;
    
    public Transacao(double value, String type){
        this.value = value;
        this.type = type;
    }

    public static void deposit(float depositAmount){
        balance += depositAmount;
        System.out.println("Depósito realizado com sucesso!");
    }

    public static void withdraw(float withdrawAmount){
        if (withdrawlAmount <= balance){
            balance -= withdrawAmount
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }
}
