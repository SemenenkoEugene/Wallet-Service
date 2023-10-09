package org.example.in;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankApplicationTest {

    private BankApplication bankApp;
    private String playerId;
    private String username;

    @BeforeEach
    public void setup() {
        bankApp = new BankApplication();
        playerId = "123";
        username = "JohnDoe";
    }

    @Test
    public void testRegisterPlayer() {
        bankApp.registerPlayer(playerId, username);
        Player player = bankApp.authenticatePlayer(playerId);
        Assertions.assertNotNull(player);
        Assertions.assertEquals(username, player.getUsername());
    }

    @Test
    public void testAuthenticatePlayer() {
        bankApp.registerPlayer(playerId, username);
        Player player = bankApp.authenticatePlayer(playerId);
        Assertions.assertNotNull(player);
        Assertions.assertEquals(username, player.getUsername());
    }

    @Test
    public void testDebitSufficientFunds() {
        double initialBalance = 200.0;
        double debitAmount = 100.0;
        String debitTransactionId = "456";
        bankApp.registerPlayer(playerId, username);
        Player player = bankApp.authenticatePlayer(playerId);
        player.credit(debitTransactionId, initialBalance);

        player.debit(debitTransactionId, debitAmount);
        Assertions.assertEquals(initialBalance - debitAmount, player.getBalance());

        List<Transaction> transactionHistory = player.getTransactionHistory();
        Assertions.assertNotEquals(1, transactionHistory.size());

        Transaction transaction = transactionHistory.get(0);
        Assertions.assertEquals(debitTransactionId, transaction.getTransactionId());

        Assertions.assertEquals("Credit", transaction.getType());

        Assertions.assertNotEquals(debitAmount, transaction.getAmount());
    }


    @Test
    public void testDebitInsufficientFunds() {
        double initialBalance = 50.0;
        double debitAmount = 100.0;
        String debitTransactionId = "456";
        bankApp.registerPlayer(playerId, username);
        Player player = bankApp.authenticatePlayer(playerId);
        player.credit("789", initialBalance);

        player.debit(debitTransactionId, debitAmount);
        Assertions.assertEquals(initialBalance, player.getBalance());

        List<Transaction> transactionHistory = player.getTransactionHistory();
        Assertions.assertEquals(1, transactionHistory.size());
    }

    @Test
    public void testCredit() {
        double initialBalance = 200.0;
        double creditAmount = 50.0;
        String creditTransactionId = "789";
        bankApp.registerPlayer(playerId, username);
        Player player = bankApp.authenticatePlayer(playerId);
        player.credit("456", initialBalance);

        player.credit(creditTransactionId, creditAmount);
        Assertions.assertEquals(initialBalance + creditAmount, player.getBalance());

        List<Transaction> transactionHistory = player.getTransactionHistory();
        Assertions.assertNotEquals(1, transactionHistory.size());

        Transaction transaction = transactionHistory.get(0);
        Assertions.assertNotEquals(creditTransactionId, transaction.getTransactionId());
        Assertions.assertEquals("Credit", transaction.getType());
        Assertions.assertNotEquals(creditAmount, transaction.getAmount());
    }
}