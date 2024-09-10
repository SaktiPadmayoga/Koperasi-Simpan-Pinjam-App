package exception;

public class BlankInputException extends Exception {
    public String message(){
        return "Inputan tidak boleh kosong !";
    }  
}
