import.java.until.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Conta> contas = new ArrayList<Conta>();
        Conta conta = null;

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

            int option = Scanner.nextInt();

            if(option == 1){
                System.out.println("Digite seu nome: ");
                String name = scanner.next();
                System.out.println("Digite seu cpf: ");
                String CPF = scanner.next();
                System.out.println("Digite o número de sua casa: ");
                String numero = scanner.next();
                System.out.println("Digite a rua: ");
                String rua = scanner.next();
                System.out.println("Digite o bairro: ");
                String bairro = scanner.next();
                System.out.println("Digite a cidade: ");
                String cidade = scanner.next();
                System.out.println("Digite seu CEP:");
                int cep = scanner.nextInt();

                Cliente.Endereco endereco = new Cliente.Endereco(numero, rua, bairro, cidade,  estado, String cep);
                Cliente cliente = new Cliente(name, CPF, adress, null);
                conta = new Conta("000-1", "0000000-0", 0, cliente);
                System.out.println("Conta criada com sucesso!");
            } else if(option == 2){
                deposit();
            } else if(option == 3){
                withdraw();
            } else if(option == 4){
                transfer();
            } else if(option == 5){
                showInfo();
            } else if(option == 6){
                showBalance();
            } else if(option == 7){
                System.out.print("Você saiu do programa!");
                break;
            } else {
                System.out.print("Opção inválida, Tente novamente:");
                int option = Scanner.nextInt();
            }
        }

    }
}
