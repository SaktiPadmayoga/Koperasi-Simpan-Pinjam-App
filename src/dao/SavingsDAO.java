package dao;

import model.*;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SavingsDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertSavings(Savings saving){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO savings (saving_id, saving_type, saving_date, payment_method, amount, to_account_id) VALUES ('" + saving.getSaving_id() + "', '" 
                    + saving.getSaving_type() + "', '" + saving.getSaving_date() + "', '" + saving.getPayment_method() + "', '" + saving.getAmount() + "', '" 
                    + saving.getTo_account_id() + "')";
            String sql_update = "UPDATE accounts SET balance = balance + " + saving.getAmount() + " WHERE account_id = '" + saving.getTo_account_id() + "'";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            int result2 = stmt.executeUpdate(sql_update);
            System.out.println("Rows affected: " + result + ", " + result2);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Savings> showListSavings() {
        conn = DbCon.makeConnection();
        
        String sql = "SELECT * FROM savings";
        System.out.println("Mengambil data Savings...");
        
        List<Savings> list = new ArrayList<>();
        
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Savings sv = new Savings(rs.getString("saving_id"), rs.getString("saving_type"), rs.getString("saving_date"), rs.getString("payment_method"), rs.getDouble("amount"), rs.getInt("to_account_id"));
                    list.add(sv);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        DbCon.closeConnection();
        
        return list;
    }
    
    public boolean checkAccount(int account_id){
        try {
            conn = DbCon.makeConnection();
            String sql = "SELECT * FROM accounts WHERE account_id = " + account_id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                stmt.close();
                rs.close();
                return true;
            } else {
                stmt.close();
                rs.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkBalance(int account_id, double amount){
        try {
            conn = DbCon.makeConnection();
            String sql = "SELECT * FROM accounts WHERE account_id = " + account_id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if(rs.getDouble("balance") >= amount){
                    stmt.close();
                    rs.close();
                    return true;
                }else{
                    stmt.close();
                    rs.close();
                    return false;
                }
            } else {
                stmt.close();
                rs.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Accounts> getAccounts(int account_id){
        List<Accounts> accounts = new ArrayList<Accounts>();
        try {
            conn = DbCon.makeConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT DISTINCT accounts.*, members.* FROM savings JOIN accounts ON savings.to_account_id = accounts.account_id JOIN members ON accounts.member_id = members.member_id WHERE savings.to_account_id = "+account_id+" LIMIT 10";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Accounts account = (new Accounts(rs.getInt("account_id"), rs.getDouble("balance"), 
                        new Members(rs.getInt("member_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"), rs.getString("address")), 
                        rs.getString("username"), rs.getString("password")));
                accounts.add(account);
            }
            stmt.close();
            rs.close();
            return accounts;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Savings singleSavings(String search_id){
        try {
            conn = DbCon.makeConnection();
            String sql = "SELECT * FROM savings WHERE saving_id = '"+search_id+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new Savings(rs.getString("saving_id"), rs.getString("saving_type"), rs.getString("saving_date"), rs.getString("payment_method"), rs.getDouble("amount"), rs.getInt("to_account_id"));
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
