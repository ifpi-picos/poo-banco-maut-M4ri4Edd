public class Transacao{
    private double value;
    private String type;
    
    public Transacao(double value, String type){
        this.value = value;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}

