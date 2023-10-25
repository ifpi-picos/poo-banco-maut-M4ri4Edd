package br.edu.ifpi.poo.notificações;

public class NotificacaoEmail implements Notificacao {

    @Override
    public void enviarNotificacao(double value, String type) {
        System.out.println("___________________________________");
        System.out.println("Enviando notificação por E-mail");
        System.out.println("Tipo: " + type);
        System.out.println("Valor: " + value);
        System.out.println("___________________________________");
    }
}
