package com.mono_car_rent.modules.rental.rental;

import com.mono_car_rent.Main;
import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.common.gui.Colors;
import com.mono_car_rent.common.gui.Fonts;
import com.mono_car_rent.common.gui.NumericTextField;
import com.mono_car_rent.common.libs.Logger;
import com.mono_car_rent.modules.customer.Customer;
import com.mono_car_rent.modules.customer.CustomerController;
import com.mono_car_rent.modules.rental.RentalController;
import com.mono_car_rent.modules.vehicle.Vehicle;
import com.mono_car_rent.modules.vehicle.VehicleController;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.*;
import javax.swing.*;

public class RentalGUI extends JFrame {
    private static final org.apache.logging.log4j.Logger logger = new Logger().getLogger();
    private final CustomerController customerController = new CustomerController();
    private final VehicleController vehicleController = new VehicleController();
    private final RentalController rentalController = new RentalController();
    public RentalGUI(Main parentComponent) {
        this.parentComponent = parentComponent;
        initComponents();
    }

    private void initComponents() {
        int WIDTH = 1000;
        GridBagConstraints gridBagConstraints;

        mainPanel = new JPanel();
        titleRental = new JLabel();
        rentalDateLabel = new JLabel();
        rentalDaysLabel = new JLabel();
        pricePerDayLabel = new JLabel();
        amountToPayLabel = new JLabel();
        titlePayments = new JLabel();
        titleValue = new JLabel();
        titlePaid = new JLabel();
        titleNumber = new JLabel();
        numberOfPaymentsLabel = new JLabel();
        saveShowPayments = new JButton();
        newCustomerButton = new JButton();
        payFirstInstallmentButton = new JButton();
        customerSelection = new JComboBox<>();
        carSelection = new JComboBox<>();
        rentalDatePlaceholder = new JTextField();
        rentalDaysField = new NumericTextField();
        pricePerDayField = new JTextField();
        amountPlaceholder = new JTextField();
        numberOfPaymentsField = new JTextField();
        paymentsPanel = new JScrollPane();
        paymentsList = new JList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setMinimumSize(new Dimension(WIDTH, 424));
        getContentPane().setLayout(new GridBagLayout());

        mainPanel.setMaximumSize(new Dimension(2147483647, 2147483647));
        mainPanel.setMinimumSize(new Dimension(WIDTH, 424));
        mainPanel.setPreferredSize(new Dimension(WIDTH, 424));

        titleRental.setFont(Fonts.getFontBoldSM());
        titleRental.setHorizontalAlignment(SwingConstants.CENTER);
        titleRental.setText("RENTAL WITH PAYMENTS");
        titleRental.setToolTipText("");

        rentalDateLabel.setText("Rental Date:");

        rentalDaysLabel.setText("Days:");

        pricePerDayLabel.setText("Price per Day:");

        amountToPayLabel.setText("AMOUNT TO PAY");

        titlePayments.setFont(Fonts.getFontBoldSM());
        titlePayments.setHorizontalAlignment(SwingConstants.CENTER);
        titlePayments.setText("PAYMENTS TO MAKE");
        titlePayments.setToolTipText("");

        titleValue.setFont(Fonts.getFontBoldSM());
        titleValue.setHorizontalAlignment(SwingConstants.CENTER);
        titleValue.setText("Value");
        titleValue.setToolTipText("");

        titlePaid.setFont(Fonts.getFontBoldSM());
        titlePaid.setHorizontalAlignment(SwingConstants.CENTER);
        titlePaid.setText("Paid?");
        titlePaid.setToolTipText("");

        titleNumber.setFont(Fonts.getFontBoldSM());
        titleNumber.setHorizontalAlignment(SwingConstants.CENTER);
        titleNumber.setText("Number");
        titleNumber.setToolTipText("");

        numberOfPaymentsLabel.setText("Number of payments:");

        saveShowPayments.setBackground(Colors.getPrimaryColor());
        saveShowPayments.setForeground(Colors.getTextPrimaryColor());
        saveShowPayments.setText("Save rental and show payments >>");
        saveShowPayments.setAutoscrolls(true);
        saveShowPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveShowPaymentsActionPerformed(evt);
            }
        });

        newCustomerButton.setBackground(new Color(220, 220, 220));
        newCustomerButton.setText("Add new Customer");
        newCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerButtonActionPerformed(evt);
            }
        });

        payFirstInstallmentButton.setBackground(new Color(220, 220, 220));
        payFirstInstallmentButton.setText("Pay First Installment");
        payFirstInstallmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payFirstInstallmentButtonActionPerformed(evt);
            }
        });

        customerSelection.setBackground(new Color(220, 220, 220));
        List<Customer> customers = getCustomers();
        customerSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Select a Customer" }));
        for (Customer customer : customers) {
            customerSelection.addItem(customer.getName());
        }
        customerSelection.setMinimumSize(new Dimension(160, 22));
        customerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectionActionPerformed(evt);
            }
        });

        carSelection.setBackground(new Color(220, 220, 220));
        List<Vehicle> vehicles = getVehicles();
        carSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Select a Vehicle" }));
        for (Vehicle vehicle : vehicles) {
            carSelection.addItem(vehicle.getPlate() + " - " + vehicle.getBrand() + " " + vehicle.getModel());
        }

        rentalDatePlaceholder.setEditable(false);
        // Set the current date as the default value in dd/mm/yyyy format
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        rentalDateValue = calendar.getTime();
        String date = String.format("%1$td/%1$tm/%1$tY", rentalDateValue);
        rentalDatePlaceholder.setText(date);

        rentalDaysField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysValueActionPerformed(evt);
            }
        });
        rentalDaysField.setMinValue(1);

        amountPlaceholder.setEditable(false);

        paymentsPanel.setViewportView(paymentsList);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleRental, GroupLayout.PREFERRED_SIZE, WIDTH, GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(newCustomerButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(customerSelection, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(carSelection, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(rentalDateLabel)
                            .addComponent(rentalDaysLabel)
                            .addComponent(pricePerDayLabel)
                            .addComponent(amountToPayLabel))
                        .addGap(15, 15, 15)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(rentalDatePlaceholder, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentalDaysField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricePerDayField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountPlaceholder, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(numberOfPaymentsLabel)
                                .addGap(5, 5, 5)
                                .addComponent(numberOfPaymentsField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(saveShowPayments))
                        .addGap(56, 56, 56)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(paymentsPanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                            .addComponent(titlePayments, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(titleNumber, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(titleValue, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(titlePaid, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                            .addComponent(payFirstInstallmentButton)))))
        );

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titleRental, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(customerSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(carSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(newCustomerButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rentalDateLabel)
                            .addComponent(rentalDatePlaceholder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(rentalDaysLabel)
                            .addComponent(rentalDaysField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pricePerDayLabel)
                            .addComponent(pricePerDayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(amountToPayLabel)
                            .addComponent(amountPlaceholder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfPaymentsLabel)
                            .addComponent(numberOfPaymentsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(saveShowPayments))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(titlePayments)
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(titleNumber)
                            .addComponent(titleValue)
                            .addComponent(titlePaid))
                        .addGap(10, 10, 10)
                        .addComponent(paymentsPanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(payFirstInstallmentButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
    }

    private List<Customer> getCustomers() {
        Pageable pageable = new Pageable(1, 99999);
        Optional<String> filter = Optional.empty();
        try {
            Page<Customer> customersPage = customerController.paginate(pageable, filter);
            return customersPage.getItems();
        } catch (Throwable e) {
            logger.error("Error while fetching customers", e);
            return new ArrayList<>();
        }
    }

    private List<Vehicle> getVehicles() {
        Pageable pageable = new Pageable(1, 99999);
        Optional<String> filter = Optional.empty();
        try {
            Page<Vehicle> vehiclesPage = vehicleController.paginate(pageable, filter);
            return vehiclesPage.getItems();
        } catch (Throwable e) {
            logger.error("Error while fetching vehicles", e);
            return new ArrayList<>();
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void payFirstInstallmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void daysValueActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void customerSelectionActionPerformed(java.awt.event.ActionEvent evt) {

        // Verificar si el usuario seleccionó "Seleccione CLIENTE"
        String selection = (String) customerSelection.getSelectedItem();

        if ("Select CUSTOMER".equals(selection)) {
            // Mostrar un mensaje si no se ha seleccionado un cliente válido
            JOptionPane.showMessageDialog(this, "Please select a valid customer.");
        } else {
            // Continuar con el procesamiento si se selecciona un cliente válido
            System.out.println("Selected customer: " + selection);
            // Aquí puedes agregar el código para manejar la selección del cliente
        }
    }

    private void saveShowPaymentsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private final Main parentComponent;
    private JButton newCustomerButton;
    private JButton payFirstInstallmentButton;
    private JLabel rentalDaysLabel;
    private JLabel rentalDateLabel;
    private JButton saveShowPayments;
    private JList<String> paymentsList;
    private JLabel numberOfPaymentsLabel;
    private JLabel amountToPayLabel;
    private JPanel mainPanel;
    private JScrollPane paymentsPanel;
    private JLabel pricePerDayLabel;
    private JComboBox<String> carSelection;
    private JComboBox<String> customerSelection;
    private JLabel titleRental;
    private JLabel titlePayments;
    private JLabel titleNumber;
    private JLabel titlePaid;
    private JLabel titleValue;
    private JTextField numberOfPaymentsField;
    private NumericTextField rentalDaysField;
    private JTextField rentalDatePlaceholder;
    private  Date rentalDateValue;
    private JTextField amountPlaceholder;
    private JTextField pricePerDayField;
}
