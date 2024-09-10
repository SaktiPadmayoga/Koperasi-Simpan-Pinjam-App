package control;

import dao.AdministratorsDAO;
import model.Administrators;
import table.TableAdministrators;
import java.util.List;

public class AdministratorsControl {
    private AdministratorsDAO adminDao = new AdministratorsDAO();
    
    public TableAdministrators showAdministrator(String query){
        List<Administrators> listAdmin = adminDao.showListAdministrator();
        TableAdministrators tabelAdministrator = new TableAdministrators(listAdmin);
        return tabelAdministrator;
    }
    
    public void insertAdministrator(Administrators admin){
        adminDao.insertAdministrator(admin);
    }
    
    public void updateAdministrator(Administrators admin){
        adminDao.updateAdministrator(admin);
    }
    
    public void deleteAdministrator(int id){
        adminDao.deleteAdministrator(id);
    }
    
    public Administrators searchAdministrators(Administrators admin){
        if(adminDao.searchAdmin(admin)!=null) return adminDao.searchAdmin(admin);
        return null;
    }
    
    public Administrators searchByUsername(String user){
        return adminDao.searchByUsername(user);
    }
    
    public int countAdmin(){
        return showAdministrator("").getRowCount();
    }
    
    public int autoGenerateID(){
        List<Administrators> listAdmin = adminDao.showListAdministrator();
        return listAdmin.get(listAdmin.size()-1).getAdministrator_id()+1;
    }
    
    public TableAdministrators showTableAdmins(String query){
        List<Administrators> list = adminDao.showAdministrators(query);
        TableAdministrators tableAccounts = new TableAdministrators(list);
        
        return tableAccounts;
    }
}
