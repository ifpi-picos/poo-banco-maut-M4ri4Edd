import br.edu.ifpi.poo.entidades.Client;
import br.edu.ifpi.poo.entidades.Conta;
import br.edu.ifpi.poo.entidades.ContaCorrente;
import br.edu.ifpi.poo.entidades.ContaPoupanca;
import br.edu.ifpi.poo.entidades.Endereco;
import br.edu.ifpi.poo.notificações.NotificacaoEmail;
import br.edu.ifpi.poo.notificações.NotificacaoSMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Conta> contas = new ArrayList<>();
        Client client1 = new Client("Maria Luz", "000.000.000-00", "18/10/2005", new Endereco("791", "ACL", "Ipueiras", "Picos", "PI", "64000"));
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n__________M E N U - B A N C O  M A U T__________");
            System.out.println("\n            1) Cadastrar Conta");
            System.out.println("            2) Reconfigurar Notificações");
            System.out.println("            3) Depositar");
            System.out.println("            4) Sacar");
            System.out.println("            5) Transferir");
            System.out.println("            6) Consultar Informações da conta");
            System.out.println("            7) Consultar Saldo");
            System.out.println("            0) Sair");
            System.out.println("            Selecione a opção desejada");
            System.out.println("________________________________________________");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("________________CADASTRO DE CONTA________________");
                System.out.println("\nSelecione o tipo de conta que deseja cadastrar:");
                System.out.println("1) Conta Corrente");
                System.out.println("2) Conta Poupança");
                System.out.println("________________________________________________");
                int acc = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o número da Conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da Agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor de Abertura");
                double abertura = scanner.nextDouble();
                if (acc == 1){
                    contas.add(new ContaCorrente(number, agencyNumber, client1, abertura, null, null));
                    System.out.println("Nova Conta Cadastrada com sucesso");
                } else if (acc == 2){
                    contas.add(new ContaPoupanca(number, agencyNumber, client1, abertura, null, null));
                    System.out.println("Nova Conta Cadastrada com sucesso");
                }

                if (contas != null){
                    for(Conta conta : contas){
                        if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                            conta.abrir(abertura);
                        }
                    }
                    System.out.println("____________________________________");
                    System.out.println("Como deseja receber Notificações ?");
                    System.out.println("1) Via SMS");
                    System.out.println("2) Via Email");
                    System.out.println("____________________________________");
                    int notif = scanner.nextInt();
                    scanner.nextLine();
                    for(Conta conta : contas){
                        if(notif == 1){
                            conta.setNotificacao(new NotificacaoSMS());
                            System.out.println("Suas notificações serão enviadas por SMS a partir de agora.");
                        } else if (notif == 2){
                            conta.setNotificacao(new NotificacaoEmail());
                            System.out.println("Suas notificações serão enviadas por Email a partir de agora.");
                        } else{
                            System.out.println("Opção Inválida");
                        }
                    }
                }
            }else if(option == 2){
                System.out.println("Digite o número da conta que deseja reconfigurar:");
                String number = scanner.nextLine();
                System.out.println("____________________________________");
                System.out.println("Como deseja receber Notificações ?");
                System.out.println("1) Via SMS");
                System.out.println("2) Via Email");
                System.out.println("____________________________________");
                int notif = scanner.nextInt();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(notif == 1 && conta.getNumber().equals(number)){
                        conta.setNotificacao(new NotificacaoSMS());
                        System.out.println("Suas notificações serão enviadas por SMS a partir de agora.");
                    } else if (notif == 2 && conta.getNumber().equals(number)){
                        conta.setNotificacao(new NotificacaoEmail());
                        System.out.println("Suas notificações serão enviadas por Email a partir de agora.");
                    } else{
                        System.out.println("Opção Inválida");
                    }
                }
            }else if(option == 3){
                System.out.println("Digite o número da Conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da Agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do Depósito");
                double deposit = scanner.nextDouble();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        conta.depositar(deposit);
                    }
                }
            }else if(option == 4){
                System.out.println("Digite o número da Conta");
                String number = scanner.nextLine();
                System.out.println("Digite o número da Agência");
                String agencyNumber = scanner.nextLine();
                System.out.println("Digite o valor do Saque");
                double saque = scanner.nextDouble();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        conta.Sacar(saque);
                    }
                }
            } else if(option == 5){
                System.out.println("Digite o número da Conta de origem");
                String numberOrigem = scanner.nextLine();
                System.out.println("Digite o número da Agência de origem");
                String agencyNumberOrigem = scanner.nextLine();
                System.out.println("Digite o número da Conta de destino");
                String numberDestino = scanner.nextLine();
                System.out.println("Digite o número da Agência de destino");
                String agencyNumberDestino = scanner.nextLine();
                System.out.println("Digite o valor da Transferência");
                double transferencia = scanner.nextDouble();
                scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(numberOrigem) && conta.getAgencyNumber().equals(agencyNumberOrigem)){
                        conta.Transferir(transferencia);
                    }
                    if(conta.getNumber().equals(numberDestino) && conta.getAgencyNumber().equals(agencyNumberDestino)){
                        conta.receberTransferencia(transferencia);
                    }
                }
            } else if(option == 6){
                System.out.println("Digite o Numero da Conta que deseja vizualizar: ");
                String number = scanner.nextLine();
                System.out.println("Digite o Numero da Agência da Conta: ");
                String agencyNumber = scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        System.out.println("____________________________________");
                        System.out.println("INFORMAÇÕES DA CONTA " + number);
                        System.out.println("Cliente: " + client1.getName());
                        System.out.println("Número da Conta: " + number);
                        System.out.println("Agência: " + agencyNumber);
                        System.out.println("CPF: " + client1.getCPF());
                        System.out.println("Data de Nascimento :" + client1.getBirthdate());
                        System.out.println("____________________________________");
                        System.out.println("HISTÓRICO DE TRANSAÇÕES");
                        conta.verExtrato();
                        System.out.println("____________________________________");
                    }
                }
            } else if(option == 7){
                System.out.println("Digite o Numero da Conta que deseja vizualizar: ");
                String number = scanner.nextLine();
                System.out.println("Digite o Numero da Agência da conta: ");
                String agencyNumber = scanner.nextLine();
                for(Conta conta : contas){
                    if(conta.getNumber().equals(number) && conta.getAgencyNumber().equals(agencyNumber)){
                        System.out.println("Saldo da Conta " + number + ": R$ " + conta.getBalance());
                    }
                }
            } else if(option == 0){
                System.out.println("       Você saiu do programa!");
                System.out.println("Obrigado por usar o sistema Banco Maut!");
                break;
            } else {
                System.out.print("Opção inválida, Tente novamente:");
            }
        }

    }
}
