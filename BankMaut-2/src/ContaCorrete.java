public class ContaCorrete extends Conta {
    private double chequeEspecial;
    private int transferenciasRestantes;

    public ContaCorrete(String number, String agencyNumber, String client, double balance, Transacao transacoes) {
        super(number, agencyNumber, client, balance, transacoes);
        this.chequeEspecial = 100;
        this.transferenciasRestantes = 2;
      }

    public double getChequeEspecial() {
        return super.balance + this.chequeEspecial;
    }

    public double getSaldoCorrente() {
        return super.getBalance();
    }

    @Override
    public boolean Transferir(Conta destino, Double valor){
        if(valor < 0 && valor <= getChequeEspecial()){
            if(transferenciasRestantes > 2){
                double taxaTransf = (valor* 0.1);
                super.balance -= (valor + taxaTransf);
                destino.balance += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacoes().add(new Transacao(valor, "Transferencia"));
                destino.getTransacoes().add(new Transacao(valor, "Recibo transferencia"));
                ++transferenciasRestantes;
                return true;
            } else {
                super.balance -= valor;
                destino.balance += valor;
                getNotificacao().enviarNotificacao("Transferencia", valor);
                transferenciasRestantes++;
                System.out.println("Transferencia realizada com sucesso !!\n");
                getTransacoes().add(new Transacao(valor, "Transferencia"));
                destino.getTransacoes().add(new Transacao(valor, "Recibo transferencia"));
                return true;
            }
        } else {
            System.err.println("Valor insuficiente para a transferência!");
            return false;
        }

    }

}
