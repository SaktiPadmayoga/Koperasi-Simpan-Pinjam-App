package table;

import javax.swing.table.AbstractTableModel;
import model.Accounts;
import java.util.List;

public class TableAccounts extends AbstractTableModel {
    private List<Accounts> accounts;

    public TableAccounts(List<Accounts> accounts){
        this.accounts = accounts;
    }

    @Override
    public int getRowCount(){
        return accounts.size();
    }

    @Override
    public int getColumnCount(){
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return accounts.get(row).getAccount_id();
            case 1: 
                return accounts.get(row).getMember().getMember_id();
            case 2: 
                return accounts.get(row).getMember().getFirst_name();
            case 3: 
                return accounts.get(row).getMember().getLast_name();
            case 4: 
                return accounts.get(row).getBalance();
            case 5: 
                return accounts.get(row).getMember().getEmail();
            case 6: 
                return accounts.get(row).getMember().getPhone_number();
            case 7: 
                return accounts.get(row).getMember().getAddress();
            case 8: 
                return accounts.get(row).getUsername();
            case 9: 
                return accounts.get(row).getPassword();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Account ID";
            case 1: 
                return "Member ID";
            case 2: 
                return "First Name";
            case 3:
                return "Last Name";
            case 4:
                return "Balance";
            case 5: 
                return "Email";
            case 6:
                return "Phone Number";
            case 7: 
                return "Address";
            default: 
                return null;
        }
    }
}
