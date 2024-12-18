package com.mono_car_rent.modules.rental.rental;


import javax.swing.*;
import java.awt.*;

public class RentalGUI extends JFrame {
    public RentalGUI() {
        initComponents();
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        mainPanel = new JPanel();
        titleRental = new JLabel();
        rentalDate = new JLabel();
        rentalDays = new JLabel();
        pricePerDay = new JLabel();
        amountToPay = new JLabel();
        titlePayments = new JLabel();
        titleValue = new JLabel();
        titlePaid = new JLabel();
        titleNumber = new JLabel();
        labelNumberOfPayments = new JLabel();
        saveShowPayments = new JButton();
        newCustomerButton = new JButton();
        payFirstInstallmentButton = new JButton();
        customerSelection = new JComboBox<>();
        carSelection = new JComboBox<>();
        dateValue = new JTextField();
        daysValue = new JTextField();
        priceValue = new JTextField();
        amountValue = new JTextField();
        numberOfPaymentsValue = new JTextField();
        paymentsPanel = new JScrollPane();
        paymentsList = new JList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setMinimumSize(new Dimension(782, 424));
        getContentPane().setLayout(new GridBagLayout());

        mainPanel.setMaximumSize(new Dimension(2147483647, 2147483647));
        mainPanel.setMinimumSize(new Dimension(782, 424));
        mainPanel.setPreferredSize(new Dimension(782, 424));

        titleRental.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        titleRental.setHorizontalAlignment(SwingConstants.CENTER);
        titleRental.setText("RENTAL WITH PAYMENTS");
        titleRental.setToolTipText("");

        rentalDate.setText("Rental Date:");

        rentalDays.setText("Days:");

        pricePerDay.setText("Price per Day:");

        amountToPay.setText("AMOUNT TO PAY");

        titlePayments.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        titlePayments.setHorizontalAlignment(SwingConstants.CENTER);
        titlePayments.setText("PAYMENTS TO MAKE");
        titlePayments.setToolTipText("");

        titleValue.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        titleValue.setHorizontalAlignment(SwingConstants.CENTER);
        titleValue.setText("Value");
        titleValue.setToolTipText("");

        titlePaid.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        titlePaid.setHorizontalAlignment(SwingConstants.CENTER);
        titlePaid.setText("Paid?");
        titlePaid.setToolTipText("");

        titleNumber.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        titleNumber.setHorizontalAlignment(SwingConstants.CENTER);
        titleNumber.setText("Number");
        titleNumber.setToolTipText("");

        labelNumberOfPayments.setText("Number of payments:");

        saveShowPayments.setBackground(new Color(220, 220, 220));
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
        customerSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Select CUSTOMER", "Customer 1", "Customer 2", "Customer 3", " " }));
        customerSelection.setMinimumSize(new Dimension(160, 22));
        customerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectionActionPerformed(evt);
            }
        });

        carSelection.setBackground(new Color(220, 220, 220));
        carSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Select CAR", "Car 1", "Car 2", "Car 3", " " }));

        dateValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateValueActionPerformed(evt);
            }
        });

        daysValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysValueActionPerformed(evt);
            }
        });

        amountValue.setEditable(false);

        paymentsPanel.setViewportView(paymentsList);

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleRental, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(customerSelection, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(carSelection, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(newCustomerButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(523, 523, 523)
                .addComponent(titlePayments, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(titleNumber, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(titleValue, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(titlePaid, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(rentalDate)
                        .addGap(7, 7, 7)
                        .addComponent(dateValue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(rentalDays)
                        .addGap(15, 15, 15)
                        .addComponent(daysValue, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(pricePerDay)
                        .addGap(13, 13, 13)
                        .addComponent(priceValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(amountToPay)
                        .addGap(4, 4, 4)
                        .addComponent(amountValue, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labelNumberOfPayments)
                        .addGap(5, 5, 5)
                        .addComponent(numberOfPaymentsValue, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addComponent(saveShowPayments))
                .addGap(56, 56, 56)
                .addComponent(paymentsPanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(payFirstInstallmentButton))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titleRental, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(customerSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(carSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(newCustomerButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(titlePayments)
                .addGap(6, 6, 6)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleNumber)
                    .addComponent(titleValue)
                    .addComponent(titlePaid))
                .addGap(5, 5, 5)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(rentalDate)
                            .addComponent(dateValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(rentalDays)
                            .addComponent(daysValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pricePerDay)
                            .addComponent(priceValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(amountToPay)
                            .addComponent(amountValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumberOfPayments)
                            .addComponent(numberOfPaymentsValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(saveShowPayments, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(paymentsPanel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(payFirstInstallmentButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 46;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
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

    private void dateValueActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private JButton newCustomerButton;
    private JButton payFirstInstallmentButton;
    private JLabel rentalDays;
    private JLabel rentalDate;
    private JButton saveShowPayments;
    private JList<String> paymentsList;
    private JLabel labelNumberOfPayments;
    private JLabel amountToPay;
    private JPanel mainPanel;
    private JScrollPane paymentsPanel;
    private JLabel pricePerDay;
    private JComboBox<String> carSelection;
    private JComboBox<String> customerSelection;
    private JLabel titleRental;
    private JLabel titlePayments;
    private JLabel titleNumber;
    private JLabel titlePaid;
    private JLabel titleValue;
    private JTextField numberOfPaymentsValue;
    private JTextField daysValue;
    private JTextField dateValue;
    private JTextField amountValue;
    private JTextField priceValue;
}
