package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;

    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxiService taxiService) {
        super();
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxiService;
    }

    // methods
    public void processInvoice(CarRental carRental) {
        long t1 = carRental.getStartDate().getTime();
        long t2 = carRental.getFinishdaDate().getTime();

        double hours = (double) ((((t2 - t1) / 1000 ) / 60 ) / 60 );
        double basicPayment;

        if(hours <= 12.0) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax((double)basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    } 
    
}
