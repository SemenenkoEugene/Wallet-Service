package org.example;

import org.example.in.BankApplication;
import org.example.in.Player;
import org.example.in.Transaction;

import java.util.List;

public class App {
    public static void main(String[] args) {
        BankApplication bankApp = new BankApplication();

        //Регистрация игрока
        String playerId = "123";
        String username = "JohnDoe";
        bankApp.registerPlayer(playerId, username);

        //Аутентификация игрока
        Player player = bankApp.authenticatePlayer(playerId);
        if (player != null) {
            System.out.println("Аутентифицированный игрок: " + player.getUsername());
            System.out.println("Текущий баланс игрока: " + player.getBalance());

            //Выполнение дебетовой транзакции
            String debitTransactionId = "456";
            double debitAmount = 100.0;
            bankApp.debit(playerId,debitTransactionId,debitAmount);
            System.out.println("Баланс после дебетовой операции: " + player.getBalance());

            //Выполнение кредитной транзакции
            String creditTransactionId = "789";
            double creditAmount = 50.0;
            bankApp.credit(playerId,creditTransactionId,creditAmount);
            System.out.println("Баланс после кредитной операции: " + player.getBalance());

            //Просмотр истории транзакций
            List<Transaction> transactionHistory = player.getTransactionHistory();
            System.out.println("История транзакций:");
            for (Transaction transaction : transactionHistory) {
                System.out.println("ID транзакций: " + transaction.getTransactionId());
                System.out.println("Тип: " + transaction.getType());
                System.out.println("Сумма: " + transaction.getAmount());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Аутентификация игрока не удалась");
        }
    }
}
