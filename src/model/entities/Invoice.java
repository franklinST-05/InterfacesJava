package model.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice() {
    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    // getter
    public Double getTax() {
        return tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    // setter
    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    // methods
    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}
