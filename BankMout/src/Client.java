import java.util.List;

public class Client {
    private String name;
    private String CPF;
    private String birthdate;
    private Endereço adress;
    private List<Conta> contas;

    public Client(String name, String CPF, String birthdate, Endereço adress){
        this.name = name;
        this.CPF = CPF;
        this.birthdate = birthdate;
        this.adress = adress;
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

   public Endereço getAdress() {
       return adress;
   }

   public List<Conta> getContas() {
       return contas;
   }
