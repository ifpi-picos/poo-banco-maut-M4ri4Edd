public class NotificacaoSMS implements Notificacao {

    @Override
    public void enviarNotificacao(String type, double value) {
        System.out.println("Enviando notificação por SMS");
        System.out.println("\nTipo: " + type);
        System.out.println("Valor: " + value);
    }
}
