package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Members;
import model.Accounts;
import control.MembersControl;

public class AccountsDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    private MembersControl m = new MembersControl();
    
    public void insertAccounts(Accounts a){
        con = dbCon.makeConnection();
       
        String sql = "INSERT INTO accounts (account_id, member_id, balance, username, password) VALUES ('" 
                + a.getAccount_id()+ "', '"+ a.getMember().getMember_id() + "', '" 
                + a.getBalance() + "', '" + a.getUsername() + "', '" + a.getPassword() + "')";
        
        System.out.println("Adding Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Accounts");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Accounts> showAccounts(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT a.*, m.* FROM accounts as a JOIN members as m ON (a.member_id = m.member_id) "
                + "WHERE (m.first_name LIKE '%"+ query +"%'"
                + "OR m.last_name LIKE '%"+ query +"%'"
                + "OR m.email LIKE '%"+ query +"%'"
                + "OR m.phone_number LIKE '%"+ query + "%'"
                + "OR m.address LIKE '%" + query + "%'"
                + "OR a.balance LIKE '%" + query + "%'"
                + "OR a.username LIKE '%" + query + "%'"
                + "OR a.password LIKE '%" + query + "%'"
                + "OR a.member_id LIKE '%" + query + "%')";
        System.out.println("Mengambil data Accounts...");       
        List<Accounts> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Members m = new Members(
                            Integer.parseInt(rs.getString("m.member_id")),
                            rs.getString("m.first_name"),
                            rs.getString("m.last_name"),
                            rs.getString("m.email"),
                            rs.getString("m.phone_number"),
                            rs.getString("m.address")
                    );

                    Accounts a = new Accounts(Integer.parseInt(rs.getString("a.account_id")), Double.parseDouble(rs.getString("a.balance")), m,
                            rs.getString("a.username"), rs.getString("a.password"));
                    
                    list.add(a);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public void updateAccounts(Accounts a){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE accounts SET balance = '" + a.getBalance() + "', username = '" + a.getUsername()
                + "', password = '" + a.getPassword()+ "' WHERE account_id = '" + a.getAccount_id() + "'";
        System.out.println("Editing Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Accounts "+ a.getAccount_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteAccounts(int account_id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM accounts WHERE account_id = " + account_id;
        System.out.println("Deleting Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Accounts " + account_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public Accounts searchAccounts(int account_id){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM accounts WHERE account_id = '" + account_id + "'";
        System.out.println("Searching Accounts...");
        Accounts a = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    a = new Accounts(rs.getInt("account_id"), rs.getDouble("balance"),
                        m.searchMembers(rs.getInt("member_id")), rs.getString("username"), 
                        rs.getString("password"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error checking search account");
            System.out.println(e.toString());
        }
        dbCon.closeConnection();
        return a;
    }
    
    public Accounts selectAccount(int account_id){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM accounts JOIN members ON accounts.member_id = members.member_id WHERE account_id = " + account_id ;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return new Accounts(Integer.parseInt(rs.getString("accounts.account_id")),
                        Double.parseDouble(rs.getString("accounts.balance")),
                        new Members(Integer.parseInt(rs.getString("members.member_id")),rs.getString("members.first_name"),rs.getString("members.last_name"),rs.getString("members.email"),rs.getString("members.phone_number"),rs.getString("members.address")),
                        rs.getString("accounts.username"), rs.getString("accounts.password"));
            }
        } catch (Exception e){
            dbCon.closeConnection();
            System.out.println("Error checking select account");
            System.out.println(e.toString());
            return null;
        }
        dbCon.closeConnection();
        return null;
    }
    
    public boolean checkAccountAvail(int account_id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM accounts WHERE account_id = " + account_id;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }
            rs.close();
            stmt.close();
        } catch (Exception e){
            System.out.println("Error checking available account");
            System.out.println(e.toString());
            return false;
        }
        dbCon.closeConnection();
        return false;
    }
    
    public Accounts checkLogin(String user, String pass){
        con= dbCon.makeConnection();
        Accounts a=null;
        String sql = "SELECT a.*,m.* FROM accounts as a JOIN members as m ON a.member_id = m.member_id WHERE a.username = '" + user + "' AND a.password = '" + pass + "'";
        try{
             Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Members m = new Members(
                            Integer.parseInt(rs.getString("m.member_id")),
                            rs.getString("m.first_name"),
                            rs.getString("m.last_name"),
                            rs.getString("m.email"),
                            rs.getString("m.phone_number"),
                            rs.getString("m.address")
                    );

                    a = new Accounts(Integer.parseInt(rs.getString("a.account_id")),
                            Double.parseDouble(rs.getString("a.balance")), m,
                            rs.getString("a.username"), rs.getString("a.password"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error to logged in...");
            System.out.println(e.toString());
        }
         dbCon.closeConnection();
        return a;
    }
}
