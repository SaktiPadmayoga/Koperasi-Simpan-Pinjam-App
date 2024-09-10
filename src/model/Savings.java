package model;

public class Savings {
    private String saving_id, saving_type, saving_date, payment_method;
    private double amount;
    private int to_account_id;

    public Savings(String saving_id, String saving_type, String saving_date, String payment_method, double amount, int to_account_id) {
        this.saving_id = saving_id;
        this.saving_type = saving_type;
        this.saving_date = saving_date;
        this.payment_method = payment_method;
        this.amount = amount;
        this.to_account_id = to_account_id;
    }

    public String getSaving_id() {
        return saving_id;
    }

    public void setSaving_id(String saving_id) {
        this.saving_id = saving_id;
    }

    public String getSaving_type() {
        return saving_type;
    }

    public void setSaving_type(String saving_type) {
        this.saving_type = saving_type;
    }

    public String getSaving_date() {
        return saving_date;
    }

    public void setSaving_date(String saving_date) {
        this.saving_date = saving_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(int to_account_id) {
        this.to_account_id = to_account_id;
    }
}
