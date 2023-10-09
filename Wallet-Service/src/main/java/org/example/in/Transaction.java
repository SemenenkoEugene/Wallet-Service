package org.example.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс описывающий сущность Транзакции
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private String transactionId;
    private String playerId;
    private String type;
    private double amount;
}
