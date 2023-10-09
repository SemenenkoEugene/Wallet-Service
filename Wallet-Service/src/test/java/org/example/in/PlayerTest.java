package org.example.in;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class PlayerTest {
    private Player player;
    private String playerId;

    @Before
    public void setup() {
        playerId = "123";
        player = new Player(playerId, "JohnDoe");
    }

    @Test
    public void testCredit() {
        String transactionId = "456";
        double amount = 100.0;
        player.credit(transactionId, amount);
        Assert.assertEquals(amount, player.getBalance(), 0.01);

        List<Transaction> transactionHistory = player.getTransactionHistory();
        Assert.assertEquals(1, transactionHistory.size());
        Transaction transaction = transactionHistory.get(0);
        Assert.assertEquals(transactionId, transaction.getTransactionId());
        Assert.assertEquals("Credit", transaction.getType());
        Assert.assertEquals(amount, transaction.getAmount(), 0.01);
    }

    @Test
    public void testDebitSufficientFunds() {
        String transactionId = "456";
        double initialBalance = 200.0;
        double debitAmount = 100.0;
        player.credit("789", initialBalance);

        player.debit(transactionId, debitAmount);
        Assert.assertEquals(initialBalance - debitAmount, player.getBalance(), 0.01);

        List<Transaction> transactionHistory = player.getTransactionHistory();
        Assert.assertEquals(2, transactionHistory.size());
        Transaction debitTransaction = transactionHistory.get(1);
        Assert.assertEquals(transactionId, debitTransaction.getTransactionId());
        Assert.assertEquals("Debit", debitTransaction.getType());
        Assert.assertEquals(debitAmount, debitTransaction.getAmount(), 0.01);
    }
}