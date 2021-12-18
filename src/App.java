import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxiService;
import model.services.RentalService;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Enter rental data");
        System.out.println("Car model");
        String carModel = scan.nextLine();
        System.out.println("Pickup (dd/MM/yyyy hh:ss): ");
        Date startDate = sdf.parse(scan.nextLine());
        System.out.println("Return (dd/MM/yyyy hh:ss): ");
        Date finishDate = sdf.parse(scan.nextLine());

        CarRental cr = new CarRental(startDate, finishDate, new Vehicle(carModel));

        System.out.println("Enter price per hour: ");
        double pricePerHour = scan.nextDouble();
        System.out.println("Enter price per day: ");
        double pricePerDay = scan.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxiService());
        rentalService.processInvoice(cr);

        System.out.println("\nINVOICE");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
        scan.close();
    }
}
