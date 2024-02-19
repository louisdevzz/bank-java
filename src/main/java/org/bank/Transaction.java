package org.bank;

import java.sql.Timestamp;


public class Transaction {
    private static int count = 0;
    private int id;
    private String uid;
    private Timestamp createAt;
    private String description;

    public Transaction(String uid,String description){
        this.id = ++count;
        this.uid = uid;
        this.createAt = new Timestamp(System.currentTimeMillis());
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uid='" + uid + '\'' +
                ", createAt=" + createAt +
                ", description='" + description + '\'' +
                '}';
    }
}
