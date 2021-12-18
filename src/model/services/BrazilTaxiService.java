package model.services;

public class BrazilTaxiService implements TaxService{

    public double tax(double amount) {
        return (amount > 100.0) ? amount * 0.5 : amount * 0.2;
    }
}
