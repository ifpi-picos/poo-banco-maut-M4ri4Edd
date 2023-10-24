package br.edu.ifpi.poo.entidades;

public class Endereco {
    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String numero, String rua, String bairro, String cidade, String estado, String cep){
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
    
}

