package org.example.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывающий сущность Игрок
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String playerId;
    private String username;
    private double balance;
    private List<Transaction> transactionHistory;

    public Player(String playerId, String username) {
        this.playerId = playerId;
        this.username = username;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Описывает дебетовые транзакции для игрока
     *
     * @param transactionId Id транзакции
     * @param amount        сумма дебетовой транзакции
     */
    public void debit(String transactionId, double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            Transaction transaction = new Transaction(transactionId, playerId, "Debit", amount);
            transactionHistory.add(transaction);
            System.out.println("Debit transaction successfully processed.");
        } else {
            System.out.println("Insufficient funds. Debit transaction failed.");
        }
    }

    /**
     * Описывает кредитные транзакции для игрока
     *
     * @param transactionId Id транзакции
     * @param amount        сумма кредитной транзакции
     */
    public void credit(String transactionId, double amount) {
        balance += amount;
        Transaction transaction = new Transaction(transactionId, playerId, "Credit", amount);
        transactionHistory.add(transaction);
        System.out.println("Credit transaction successfully processed.");
    }
}
