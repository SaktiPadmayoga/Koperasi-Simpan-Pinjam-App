package control;

import dao.SavingsDAO;
import dao.TransactionsDAO;
import java.util.List;
import model.Savings;
import model.Accounts;
import model.TransactionsJoins;
import table.TableDaftarSavings;
import table.TableJoinSavings;

public class SavingsControl {
    private SavingsDAO savingsDAO = new SavingsDAO();
    private TransactionsDAO transactionsDAO = new TransactionsDAO();

    public void insertSavings(Savings saving){
        savingsDAO.insertSavings(saving);
    }

    public boolean checkAccount(int account_id){
        return savingsDAO.checkAccount(account_id);
    }

    public boolean checkBalance(int account_id, double amount){
        return savingsDAO.checkBalance(account_id, amount);
    }

    public TableDaftarSavings getAccounts(int account_id){
        List<Accounts> accounts = savingsDAO.getAccounts(account_id);
        TableDaftarSavings table = new TableDaftarSavings(accounts);
        return table;
    }
    
    public TableJoinSavings showSavings(String type, String status1, String status2){
        List<TransactionsJoins> sv = transactionsDAO.showAllTransactions(type, status1, status2);
        TableJoinSavings table = new TableJoinSavings(sv);
        return table;
    }
    
    public Savings singleSavings(String search_id){
        return savingsDAO.singleSavings(search_id);
    }
    
}
