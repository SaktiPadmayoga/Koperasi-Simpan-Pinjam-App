package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Members;
import model.Accounts;

public class TableMembers extends AbstractTableModel{
    private List<Members> members;

    public TableMembers(List<Members> members){
        this.members = members;
    }

    @Override
    public int getRowCount(){
        return members.size();
    }

    @Override
    public int getColumnCount(){
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return members.get(row).getMember_id();
            case 1: 
                return members.get(row).getFirst_name();
            case 2:
                return members.get(row).getLast_name();
            case 3:
                return members.get(row).getEmail();
            case 4:
                return members.get(row).getPhone_number();
            case 5:
                return members.get(row).getAddress();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Member ID";
            case 1:
                return "First Name";
            case 2:
                return "Last Name";
            case 3:
                return "Email";
            case 4:
                return "Phone Number";
            case 5:
                return "Address";
            default: 
                return null;
        }
    }
}
