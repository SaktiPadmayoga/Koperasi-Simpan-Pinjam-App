package control;

import dao.LoansDAO;
import dao.TransactionsDAO;
import model.Loans;
import java.util.List;
import model.TransactionsJoins;
import table.TableJoinLoans;

public class LoansControl {
    private LoansDAO LoansDAO = new LoansDAO();
    private TransactionsDAO transactionDao = new TransactionsDAO();

    public void insertLoan(Loans loan){
        LoansDAO.insertLoan(loan);
    }

    public void updateLoan(Loans loan){
        LoansDAO.updateLoan(loan);
    }

    public void deleteLoan(Loans loan){
        LoansDAO.deleteLoan(loan);
    }

    public Loans getLoan(String loan_id, String status){
        return LoansDAO.getLoan(loan_id, status);
    }

    public TableJoinLoans showAllJoinLoans(String type, String status1, String status2){
        List<TransactionsJoins> tf = transactionDao.showAllTransactions(type, status1, status2);
        TableJoinLoans table = new TableJoinLoans(tf);
        return table;
    }
}
