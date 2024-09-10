package model;

public class Accounts {
    private int account_id;
    private String username, password;
    private double balance;
    private Members member;

    public Accounts(int account_id, double balance, Members member, String username, String password) {
        this.account_id = account_id;
        this.balance = balance;
        this.member = member;
        this.username = username;
        this.password = password;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }
}
