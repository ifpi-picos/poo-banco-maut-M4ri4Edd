import java.util.List;

public class Client {
    private String name;
    private String CPF;
    private String birthdate;
    private String adress;
    private List<Conta> contas;

    public Client(String name, String CPF, String birthdate, String adress){
        this.name = name;
        this.CPF = CPF;
        this.birthdate = birthdate;
        this.adress = adress;
    }

   public Client(String name2, String cPF2, String birthdate2, Endereço endereço) {
    }

public String getName() {
       return name;
   }

   public String getCPF() {
       return CPF;
   }

   public String getBirthdate() {
       return birthdate;
   }

   public String getAdress() {
       return adress;
   }

   public List<Conta> getContas() {
       return contas;
   }

    public String showInfo(){
        return "\nNome: " + this.getName() +
        "\nCPF: " + this.getCPF() +
        "\nNascimento: " + this.getBirthdate() +
        "\nEndereco: " + this.getAdress();
    }

    public enum adress {
    }
}