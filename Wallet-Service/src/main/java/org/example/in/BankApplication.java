package org.example.in;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывающий функционал банковского приложения, такой как регистрация, аутентификация и
 * выполнение транзакций
 */

@AllArgsConstructor
public class BankApplication {

    private Map<String, Player> players;

    public BankApplication() {
        this.players = new HashMap<>();
    }

    /**
     * Регистрация игрока в системе
     *
     * @param playerId Id игрока
     * @param username Имя игрока
     */
    public void registerPlayer(String playerId, String username) {
        Player player = new Player(playerId, username);
        players.put(playerId, player);
        System.out.println("Player registered successfully.");
    }

    /**
     * Аутентификация игрока в системе
     *
     * @param playerId Id игрока
     * @return Игрока в системе
     */
    public Player authenticatePlayer(String playerId) {
        return players.get(playerId);
    }

    /**
     * Дебетовая транзакция
     *
     * @param playerId      Id игрока
     * @param transactionId Id транзакции
     * @param amount        сумма транзакции
     */
    public void debit(String playerId, String transactionId, double amount) {
        Player player = authenticatePlayer(playerId);
        if (player != null) {
            player.debit(transactionId, amount);
        } else {
            System.out.println("Player not found. Debit transaction failed.");
        }
    }

    /**
     * Кредитная транзакция
     *
     * @param playerId      Id игрока
     * @param transactionId Id транзакции
     * @param amount        сумма транзакции
     */
    public void credit(String playerId, String transactionId, double amount) {
        Player player = authenticatePlayer(playerId);
        if (player != null) {
            player.credit(transactionId, amount);
        } else {
            System.out.println("Player not found. Credit transaction failed.");
        }
    }
}
