package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Members;

public class MembersDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertMembers(Members m){
        con = dbCon.makeConnection();
       
        String sql = "INSERT INTO members(member_id, first_name, last_name, email, phone_number, address) "
                + "VALUES ('" + m.getMember_id() + "', '" + m.getFirst_name() + "', '" + m.getLast_name() + "', '"
                + m.getEmail() + "', '" + m.getPhone_number() + "', '" + m.getAddress() + "')";
     
        System.out.println("Adding Members...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Members");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Members...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Members> showListMembers() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM members";
        System.out.println("Mengambil data Members...");
        
        List<Members> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Members m = new Members(
                            Integer.parseInt(rs.getString("member_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address")
                    );
                    list.add(m);
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
    
    
    public List <Members> showMembersBySearch(String query){
        con = dbCon.makeConnection();
       
        String sql = "SELECT * FROM members as m WHERE (m.member_id LIKE '%" + query + "%' "
                + " OR m.first_name LIKE '%" + query + "%' "
                + " OR m.last_name LIKE '%" + query + "%' "
                + " OR m.email LIKE '%" + query + "%' "
                + " OR m.phone_number LIKE '%" + query + "%' "
                + " OR m.address LIKE '%" + query + "%')";
        System.out.println("Mengambil data Members by Search...");
        Members m = null;
        List <Members> listMembers = new ArrayList<>();
       
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
           
            if(rs!=null){
                while(rs.next()){
                    m = new Members(
                            Integer.parseInt(rs.getString("member_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address")
                    );
                    listMembers.add(m);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
       
        return listMembers;
    }
    
    public void updateMembers(Members m){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE members SET first_name = '" + m.getFirst_name()
                + "', last_name = '" + m.getLast_name()
                + "', email = '" + m.getEmail()
                + "', phone_number = '" + m.getPhone_number()
                + "', address = '" + m.getAddress()
                + "' WHERE customer_id = '" + m.getMember_id() + "'";
        System.out.println("Editing Members...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Members "+ m.getMember_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Members...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    } 
    
    public void deleteMembers(int member_id){
        con = dbCon.makeConnection();
       
        String sql = "DELETE FROM members WHERE member_id = '" + member_id + "'";
        System.out.println("Deleting Members...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Members " + member_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Members...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
        public Members searchMembers(int member_id){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM members WHERE member_id = '"+ member_id +"'";
        System.out.println("Searching Members...");
        Members m = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    m = new Members(member_id, rs.getString("first_name"),
                            rs.getString("last_name"), rs.getString("email"),
                            rs.getString("phone_number"), rs.getString("address"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
        }
        dbCon.closeConnection();
        return m;
    }
}
