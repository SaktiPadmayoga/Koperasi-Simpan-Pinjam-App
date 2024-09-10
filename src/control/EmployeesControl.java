package control;

import dao.EmployeesDAO;
import model.Employees;
import table.TableEmployees;
import java.util.List;

public class EmployeesControl {
    private EmployeesDAO employeeDao = new EmployeesDAO();
    
    public TableEmployees showEmployees(String query){
        List<Employees> listEmployee = employeeDao.showListEmployees();
        TableEmployees tabelemployee = new TableEmployees(listEmployee);
        return tabelemployee;
    }
    
    public void insertEmployees(Employees employees){
        employeeDao.insertEmployee(employees);
    }
    
    public void updateEmployees(Employees employees){
        employeeDao.updateEmployee(employees);
    }
    
    public void deleteEmployees(int id){
        employeeDao.deleteEmployee(id);
    }
    
    public Employees searchEmployees(Employees e){
        return employeeDao.searchEmployee(e);
    }
    
    public Employees searchByUsername(String user){ 
        return employeeDao.searchByUsername(user);
    }
    
    public int countEmployee(){
        return showEmployees("").getRowCount();
    }
    
    public int autoGenerateID(){
        List<Employees> listEmp = employeeDao.showListEmployees();
        int max=0;
        for(int i=0;i<listEmp.size();i++){
            if(max<listEmp.get(i).getEmployee_id())
                 max=listEmp.get(i).getEmployee_id();
        }
        return max+1;
    }
    
    public TableEmployees showTableEmp(String query){
        List<Employees> list = employeeDao.searchShowEmp(query);
        TableEmployees table = new TableEmployees(list);
        return table;
    }
}
