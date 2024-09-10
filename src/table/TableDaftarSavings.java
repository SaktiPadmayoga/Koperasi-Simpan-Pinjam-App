package table;

import javax.swing.table.AbstractTableModel;
import model.Accounts;
import java.util.List;

public class TableDaftarSavings extends AbstractTableModel{
    private List<Accounts> accounts;

    public TableDaftarSavings(List<Accounts> accounts){
        this.accounts = accounts;
    }

    @Override
    public int getRowCount(){
        return accounts.size();
    }

    @Override
    public int getColumnCount(){
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return accounts.get(row).getAccount_id();
            case 1: 
                return accounts.get(row).getMember().getFirst_name() + " " + accounts.get(row).getMember().getLast_name();
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
                return "Nama";
            default: 
                return null;
        }
    }
    
}
