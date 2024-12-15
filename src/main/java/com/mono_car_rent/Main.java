package com.mono_car_rent;

import com.mono_car_rent.modules.customer.Customer;
import com.mono_car_rent.modules.rental.Rental;
import com.mono_car_rent.modules.rental_return.RentalReturn;
import com.mono_car_rent.modules.vehicle.Vehicle;
import com.mono_car_rent.modules.vehicle.VehicleConditionStatus;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        // Success case
        logSuccessCase();
    }

    public static void logSuccessCase() {
        logger.info("------- Showing a success case -------");
        // - Crear y validar un cliente.
        logger.info("Creating a customer...");
        Customer customer = new Customer();
        customer.setName("Juan Pérez Jackson");
        customer.setIdentityCard("20023066-3");
        logger.info("Customer created!");
        logger.info(customer.toString());
        // - Crear y validar un vehículo.
        logger.info("Creating a vehicle...");
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate("CZSL60");
        vehicle.setBrand("TOYOTA");
        vehicle.setModel("COROLLA");
        vehicle.setManufactureYear(2020);
        logger.info("Vehicle created!");
        logger.info(vehicle.toString());
        // - Deshabilitar un cliente y validar.
        logger.info("Disabling a customer...");
        customer.setValidity(false);
        logger.info("Customer disabled!");
        logger.info(customer.toString());
        // - Asignar un vehículo en mantención y validar.
        logger.info("Assigning a vehicle in maintenance...");
        vehicle.setCondition(VehicleConditionStatus.EN_MANTENCION);
        logger.info("Vehicle assigned in maintenance!");
        logger.info(vehicle.toString());
        // - Probar el ingreso de arriendos y generar tickets.
        logger.info("Creating a rental...");
        Rental rental = new Rental();
        try {
            rental.setCustomer(customer);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            logger.info("Customer is going to revert to active...");
            customer.setValidity(true);
            logger.info("Customer reverted to active!");
            logger.info(customer.toString());
        }
        rental.setVehicle(vehicle);
        rental.setCustomer(customer);
        rental.setRentalDays(3);
        rental.setRentalPricePerDay(45000);
        var rentalDate = Calendar.getInstance();
        rentalDate.set(2021, 9, 1);
        rental.setRentalDate(rentalDate.getTime());
        logger.info("Rental created here is the receipt:");
        logger.info(rental.toReceipt());
        // - Probar devoluciones y validar.
        logger.info("Creating a rental return...");
        RentalReturn rentalReturn = new RentalReturn();
        rentalReturn.setRental(rental);
        rentalReturn.setReturnDate(new Date());
        logger.info("Rental return created!");
        logger.info(rentalReturn.toString());
    }
}
