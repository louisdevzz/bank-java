package org.bank;

import java.sql.Timestamp;
import java.util.Random;

public class Bank {
    private static int count = 0;
    private int id;
    private Long numberAccount;
    private String fullName;
    private String sex;
    private String yearOfBirth;
    private String address;
    private String numberPhone;
    private String identificationCard;
    private int pin;
    private Long numberMoney;

    private Timestamp createAt;

    public Bank(String fullName){
        this.id = ++count;
        this.fullName = fullName;
        this.sex = "";
        this.yearOfBirth = "";
        this.address = "";
        this.numberPhone = "";
        this.identificationCard = "";
        this.numberAccount = 10000000000L + (long) (Math.random() * (99999999999L - 10000000000L));
        this.pin = 100 + (int) (new Random().nextFloat() * (999 - 100));
        this.numberMoney = 0L;
        this.createAt = new Timestamp(System.currentTimeMillis());
    }

    public void updateInformation( String sex, String yearOfBirth, String address, String numberPhone, String identificationCard){
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.numberPhone = numberPhone;
        this.identificationCard = identificationCard;
    }
    public void setNumberMoney(Long amount){
        this.numberMoney = amount;
    }

    public Long getNumberAccount() {
       return  numberAccount;
    }

    public String getFullName(){
        return fullName;
    }

    @Override
    public String toString() {
        return "Information Account Bank! \nAccount Number: " + numberAccount +"\n"+
                "Full Name: " + fullName  +"\n"+
                "sex: " + sex  +"\n"+
                "Year of Birth: " + yearOfBirth  +"\n"+
                "Address: " + address  +"\n"+
                "Phone Number: " + numberPhone  +"\n"+
                "Identification Card: " + identificationCard+"\n"+
                "Code Pin: " + pin +"\n"+
                "Money: " + numberMoney;
    }
}
