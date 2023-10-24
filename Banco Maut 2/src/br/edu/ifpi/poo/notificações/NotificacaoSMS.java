package br.edu.ifpi.poo.notificações;

public class NotificacaoSMS implements Notificacao {

    @Override
    public void enviarNotificacao(double value, String type) {
        System.out.println("Enviando notificação por SMS");
        System.out.println("\nTipo: " + type);
        System.out.println("Valor: " + value);
    }
}
