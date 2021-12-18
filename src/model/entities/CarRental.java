package model.entities;

import java.util.Date;

public class CarRental {
    private Date startDate;
    private Date finishDate;

    private Vehicle vehicle;
    private Invoice invoice;

    public CarRental() {  }

    public CarRental(Date startDate, Date finishdaDate, Vehicle vehicle) {
        this.startDate = startDate;
        this.finishDate = finishdaDate;
        this.vehicle = vehicle;
    }

    // getter
    public Date getStartDate() {
        return this.startDate;
    }

    public Date getFinishdaDate() {
        return this.finishDate;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }


    // setter
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setFinishdaDate(Date finishdaDate) {
        this.finishDate = finishdaDate;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
