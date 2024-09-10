package model;

public class TransactionsJoins {
    Transactions tn;
    Savings sv;
    Loans l;

    public TransactionsJoins() {
    }

    public TransactionsJoins(Transactions tn, Savings sv, Loans l) {
        this.tn = tn;
        this.sv = sv;
        this.l = l;
    }

    public Transactions getTn() {
        return tn;
    }

    public void setTn(Transactions tn) {
        this.tn = tn;
    }

    public Savings getSv() {
        return sv;
    }

    public void setSv(Savings sv) {
        this.sv = sv;
    }

    public Loans getL() {
        return l;
    }

    public void setL(Loans l) {
        this.l = l;
    }
}
