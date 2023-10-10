package bank.maut;

public class Client {
    private String name;
    private String CPF;
    private String birthdate;
    private String adress;

    public Client(String name, String CPF, String birthdate, String adress){
        this.name = name;
        this.CPFr = CPF;
        this.birthdate = birthdate;
        this.adress = adress;
    }

    public String getName{
        return name;
    }

    public String getCPF{
        return CPF;
    }

    public String getBirthdate{
        return birthdate;
    }

    public String getAdress{
        return adress;
    }

    public String setName{
        this.name = name;
    }

    public String setAdress{
        this.adress = adress;
    }
}