package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //prepare to send mail
       System.out.println("This application is supposed to send mails");

        SendMail mailer = new SendMail();
       mailer.sendAttachment();
    }
}