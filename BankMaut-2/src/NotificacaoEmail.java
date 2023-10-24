public class NotificacaoEmail implements Notificacao {

    @Override
    public void enviarNotificacao(String type, double value) {
        System.out.println("Enviando notificação por e-mail");
        System.out.println("\nTipo: " + type);
        System.out.println("Valor: " + value);
    }
}
