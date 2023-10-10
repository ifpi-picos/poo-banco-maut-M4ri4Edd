package bank.maut;
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
    }

    public static void withdraw(float withdrawAmount){
        if (withdrawlAmount <= balance){
            balance -= withdrawAmount
        } else {

        }
    }
}