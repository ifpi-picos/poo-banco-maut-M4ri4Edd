package bank.maut;

public class Conta {
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Conta(String numero, String rua, String bairro, double cidade, String estado, String cep){
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep
    }

    public String getNumero{
        return numero;
    }

    public String getRua{
        return rua;
    }

    public String getBairro{
        return bairro;
    }
    
    public String getCidade{
        return cidade;
    }
    
    public String getEstado{
        return estado;
    }
    
    public String getCEP{
        return cep;
    }

    public String setNumero{
        this.numero = numero;
    }

    public String setRua{
        this.rua = rua;
    }

    public String setBairro{
        this.bairro = bairro;
    }
    
    public String setCidade{
        this.cidade = cidade;
    }
    
    public String setEstado{
        this.estado = estado;
    }
    
    public String setCEP{
        this.cep = cep;
    }
}