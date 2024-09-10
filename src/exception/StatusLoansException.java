package exception;

public class StatusLoansException extends Exception{
    public String message(){
        return "Status Peminjaman Tidak Valid";
    }
}
