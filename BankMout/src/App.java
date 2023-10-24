import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        List<Conta> contas = new ArrayList<>();
        Client client1 = new Client("Maria Luz", "000.000.000-00", "18/10/2005", new Endereço("791", "ACL", "Ipueiras", "Picos", "PI", "64000"));
        Scanner scanner = new Scanner(System.in);

        contas.add(new Conta("1", "00001", "client1", 100.00, null));
        contas.add(new Conta("2", "00001", "client1", 100.00, null));

        while(true){
            System.out.println("===MENU - BANCO MAUT===");
            System.out.println("1) Depositar");
            System.out.println("2) Sacar");
            System.out.println("3) Transferir");
            System.out.println("4) Consultar Informações da conta");
            System.out.println("5) Consultar Saldo");
            System.out.println("6) Sair");
            System.out.println("Selecione a opção desejada");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Digite o número da conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do depósito");
                double deposit = scanner.nextDouble();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        conta.depositar(deposit);
                        conta.adicionarTransacao(deposit, "Depósito");
                    }
                }
            } else if(option == 2){
                System.out.println("Digite o número da conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do Saque");
                double saque = scanner.nextDouble();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        conta.Sacar(saque);
                        conta.adicionarTransacao(saque, "Saque");
                    }
                }
            } else if(option == 3){
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
                for(Conta conta : contas){
                    if(conta.getNumber().equals(numberOrigem) && conta.getAgencyNumber().equals(agencyNumberOrigem)){
                        conta.Transferir(transferencia);
                        conta.adicionarTransacao(transferencia, "Transferência");
                    }
                }
            } else if(option == 4){
                System.out.println("Digite o Numero da conta que deseja vizualizar: ");
                String number = scanner.nextLine();
                System.out.println("Digite o Numero da agência da conta: ");
                String agencyNumber = scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        System.out.println("INFORMAÇÕES DA CONTA " + number);
                        System.out.println("Cliente: " + client1.getName());
                        System.out.println("Número da conta: " + number);
                        System.out.println("Agência: " + agencyNumber);
                        System.out.println("CPF: " + client1.getCPF());
                        System.out.println("Data de Nascimento :" + client1.getBirthdate());
                        System.out.println("HISTÓRICO DE TRANSAÇÕES");
                        conta.verExtrato();
                    }
                }
            } else if(option == 5){
                System.out.println("Digite o Numero da conta que deseja vizualizar: ");
                String number = scanner.nextLine();
                System.out.println("Digite o Numero da agência da conta: ");
                String agencyNumber = scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        System.out.println("Saldo da conta " + number + ": R$ " + conta.getBalance());
                    }
                }
            } else if(option == 6){
                System.out.print("Você saiu do programa!");
                break;
            } else {
                System.out.print("Opção inválida, Tente novamente:");
            }
        }

    }

}
