import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Client client1 = new Client("Maria Luz", "000.000.000-00", "18/10/2005", new Endereço(791, "ACL", "Ipueiras", "Picos", "PI", "64000"));
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("MENU - BANCO MAUT");
            System.out.println("1) Cadastrar conta");
            System.out.println("2) Depositar");
            System.out.println("3) Sacar");
            System.out.println("4) Transferir");
            System.out.println("5) Consultar Informações da conta");
            System.out.println("6) Consultar Extrato");
            System.out.println("7) Sair");
            System.out.println("Selecione a opção desejada");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Digite o número da conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor de abertura");
                double abertura = scanner.nextDouble();
                scanner.nextLine();
                Conta conta = new Conta(number, agencyNumber, abertura, client1);
                System.out.println("Conta criada com sucesso");
            } else if(option == 2){
                System.out.println("Digite o número da conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do depósito");
                double deposit = scanner.nextDouble();
                scanner.nextLine();
                Conta conta = new Conta(number, agencyNumber, 0, null);
                conta.depositar(deposit);
                System.out.println("Depósito realizado com sucesso");
            } else if(option == 3){
                System.out.println("Digite o número da conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do Saque");
                double saque = scanner.nextDouble();
                scanner.nextLine();
                Conta conta = new Conta(number, agencyNumber, 0, null);
                conta.Sacar(saque);
            } else if(option == 4){
                    System.out.println("Digite o número da conta de origem");
                    String numberOrigem = scanner.nextLine();
                    System.out.println("Digite o número da agência de origem");
                    String agencyNumberOrigem = scanner.nextLine();
                    System.out.println("Digite o número da conta de destino");
                    String numberDestino = scanner.nextLine();
                    System.out.println("Digite o número da agência de destino");
                    String agencyNumberDestino = scanner.nextLine();
                    System.out.println("Digite o valor da transferência");
                    double transferencia = scanner.nextDouble();
                    scanner.nextLine();
                    Conta contaOrigem = new Conta(numberOrigem, agencyNumberOrigem, 0, null);
                    Conta contaDestino = new Conta(numberDestino, agencyNumberDestino, 0, null);
                    contaOrigem.Transferir(contaDestino, transferencia);
            } else if(option == 5){
                showInfo();
            } else if(option == 6){
                showBalance();
            } else if(option == 7){
                System.out.print("Você saiu do programa!");
                break;
            } else {
                System.out.print("Opção inválida, Tente novamente:");
            }
        }

    }

}
