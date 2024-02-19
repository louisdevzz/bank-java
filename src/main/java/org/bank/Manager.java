package org.bank;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;

import java.util.*;
public class Manager {
    private ArrayList<Bank> banks;
    private ArrayList<User> users;
    private Map<String, ArrayList<Transaction>> trans;
    private String connectionString = "mongodb+srv://louisdevzz04:vohuunhan1310@cluster0.zmwbg2i.mongodb.net/?retryWrites=true&w=majority";
    private ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();
    private MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();
    public Manager(){
        this.banks = new ArrayList<Bank>();
        this.users = new ArrayList<User>();
        this.trans = new TreeMap<String, ArrayList<Transaction>>();
        User accountBank = new User("test","test","test");
        this.users.add(accountBank);
        Bank numberBank = new Bank("Test");
        this.banks.add(numberBank);
    }

    public void createBankAccount(String username, String password,String fullName){
        User accountBank = new User(username,password,fullName);
        this.users.add(accountBank);

        Bank numberBank = new Bank(fullName);
        this.banks.add(numberBank);
        Long uid = 10000000000L + (long) (Math.random() * (99999999999L - 10000000000L));
        Transaction trns = new Transaction(uid.toString(),"Create account with Name: "+fullName);
        ArrayList<Transaction> ub = new ArrayList<Transaction>();
        ub.add(trns);
        this.trans.put(uid.toString(),ub);
        System.out.println("Create Account Bank Successful");
    }

    public void loginAccount(String username, String password){
        for(User u: this.users){
            if(u.existAccount(username,password)){
                System.out.println("login success!!!");
            }
        }
    }

    public void updateInformationAccountBank(String sex, String yearOfBirth, String address, String numberPhone, String identificationCard){
        for(Bank b: this.banks){
            b.updateInformation(sex,yearOfBirth,address,numberPhone,identificationCard);
        }
    }

    public void transferMoney(Long numberAccountFrom,Long numberAccountTo,Long amount) {
        for (Bank b : this.banks) {
            if (b.getNumberAccount().compareTo(numberAccountTo) == 0) {
                b.setNumberMoney(amount);
                System.out.println("Transfer success from " + numberAccountFrom.toString() + " to " + numberAccountTo.toString() + " with the money of " + Long.toString(amount));
            }
        }
    }
    public void depositMoney(Long numberAccount,Long amount) {
        for (Bank b : this.banks) {
            if (b.getNumberAccount().compareTo(numberAccount) == 0) {
                b.setNumberMoney(amount);
                System.out.println("Deposit success into "+numberAccount + " with the money of " + Long.toString(amount));
            }
        }
    }

    public ArrayList<User> User(){
        return users;
    }
    public ArrayList<Bank> Bank(){
        return banks;
    }
    public  Map<String, ArrayList<Transaction>> Trans(){
        return trans;
    }
}
