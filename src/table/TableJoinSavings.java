package table;

import javax.swing.table.AbstractTableModel;
import model.Savings;
import java.util.List;
import model.Transactions;
import model.TransactionsJoins;

public class TableJoinSavings extends AbstractTableModel{
    private List<TransactionsJoins> savings;

    public TableJoinSavings(List<TransactionsJoins> savings) {
        this.savings = savings;
    }
    
    @Override
    public int getRowCount(){
        return savings.size() ;
    }

    @Override
    public int getColumnCount(){
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return savings.get(row).getTn().getTransaction_id();
            case 1: 
                return savings.get(row).getSv().getSaving_id();
            case 2: 
                return savings.get(row).getSv().getSaving_type();
            case 3: 
                return savings.get(row).getSv().getSaving_date();
            case 4: 
                return savings.get(row).getSv().getTo_account_id();
            case 5: 
                return savings.get(row).getSv().getAmount();
            case 6:
                return savings.get(row).getSv().getPayment_method();
            case 7:     
                return savings.get(row).getTn().getTransaction_date();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0:
                return "Transcation ID";
            case 1: 
                return "Saving ID";
            case 2: 
                return "Saving Type";
            case 3: 
                return "Saving Date";
            case 4:
                return "Account ID";
            case 5:
                return "Amount";
            case 6:
                return "Payment Method";
            default: 
                return null;
        }
    }
}
