package bank.maut;
import.java.until.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.println("MENU - BANCO MAUT");
            System.out.println("1) Cadastrar conta");
            System.out.println("2) Alterar Informacões do cliente");
            System.out.println("3) Depositar");
            System.out.println("4) Sacar");
            System.out.println("5) Transferir");
            System.out.println("6) Consultar Informações da conta");
            System.out.println("7) Consultar Extrato");
            System.out.println("8) Sair");
            System.out.println("Selecione a opção desejada");

            int option = Scanner.nextInt();

            if(option == 1){

            } else if(option == 2){
                
            } else if(option == 3){

            } else if(option == 4){
                
            } else if(option == 5){

            } else if(option == 6){

            } else if(option == 7){

            } else if(option == 8){
                System.out.print("Você saiu do programa!");
                break;
            } else {
                System.out.print("Opção inválida, Tente novamente:");
                int option = Scanner.nextInt();
            }
        }

        // public static void novaConta()

    }
}
