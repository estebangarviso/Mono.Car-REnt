package com.mono_car_rent.modules.rental.rental_instalment;

import javax.swing.*;
import java.awt.*;

public class RentalWithInstalmentsGUI extends JFrame {

    /**
     * Creates new form RentalWithInstalmentsGUI
     */
    public RentalWithInstalmentsGUI() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new JPanel();
        rentalInstalmentsTitle = new JLabel();
        customerComboBox = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        rentalList = new JList<>();
        rentalDateLabel = new JLabel();
        showPaymentsButton = new JButton();
        paymentsLabel = new JLabel();
        numberTitle = new JLabel();
        valueTitle = new JLabel();
        paidTitle = new JLabel();
        paymentsScrollPane = new JScrollPane();
        paymentsList = new JList<>();
        payButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(782, 424));
        setPreferredSize(new Dimension(782, 424));

        rentalInstalmentsTitle.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        rentalInstalmentsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        rentalInstalmentsTitle.setText("PAY RENTAL INSTALMENTS");
        rentalInstalmentsTitle.setToolTipText("");

        customerComboBox.setBackground(new Color(220, 220, 220));
        customerComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Select customers", "Item 1", "Item 2", "Item 3", "Item 4" }));

        rentalList.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        rentalList.setToolTipText("");
        scrollPane1.setViewportView(rentalList);

        rentalDateLabel.setText("Select rental:");

        showPaymentsButton.setBackground(new Color(220, 220, 220));
        showPaymentsButton.setText("Show payments for selected rental >>>");
        showPaymentsButton.setAutoscrolls(true);
        showPaymentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMostrarCuotasActionPerformed(evt);
            }
        });

        paymentsLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        paymentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paymentsLabel.setText("P A Y M E N T S");

        numberTitle.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        numberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        numberTitle.setText("Number");
        numberTitle.setToolTipText("");

        valueTitle.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        valueTitle.setHorizontalAlignment(SwingConstants.CENTER);
        valueTitle.setText("Value");
        valueTitle.setToolTipText("");

        paidTitle.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        paidTitle.setHorizontalAlignment(SwingConstants.CENTER);
        paidTitle.setText("Paid?");
        paidTitle.setToolTipText("");

        paymentsScrollPane.setViewportView(paymentsList);

        payButton.setBackground(new Color(220, 220, 220));
        payButton.setText("Make Payment");

        GroupLayout panelPagoArriendoLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(panelPagoArriendoLayout);
        panelPagoArriendoLayout.setHorizontalGroup(
            panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rentalInstalmentsTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane1)
                    .addComponent(rentalDateLabel, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                        .addComponent(showPaymentsButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(paymentsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                                            .addComponent(numberTitle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(valueTitle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(paidTitle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(paymentsScrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelPagoArriendoLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 105, GroupLayout.PREFERRED_SIZE)
                                .addComponent(payButton)
                                .addGap(27, 27, 27)))
                        .addGap(20, 20, 20))
                    .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                        .addComponent(customerComboBox, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelPagoArriendoLayout.setVerticalGroup(
            panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelPagoArriendoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(rentalInstalmentsTitle, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                        .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(numberTitle)
                            .addComponent(valueTitle)
                            .addComponent(paidTitle))
                        .addGap(6, 6, 6)
                        .addComponent(paymentsScrollPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                        .addComponent(paymentsLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rentalDateLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPagoArriendoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPagoArriendoLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(showPaymentsButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(payButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void guardarMostrarCuotasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private JButton payButton;
    private JLabel rentalDateLabel;
    private JButton showPaymentsButton;
    private JComboBox<String> customerComboBox;
    private JScrollPane scrollPane1;
    private JLabel paymentsLabel;
    private JList<String> rentalList;
    private JList<String> paymentsList;
    private JScrollPane paymentsScrollPane;
    private JPanel mainPanel;
    private JLabel rentalInstalmentsTitle;
    private JLabel numberTitle;
    private JLabel paidTitle;
    private JLabel valueTitle;
}
