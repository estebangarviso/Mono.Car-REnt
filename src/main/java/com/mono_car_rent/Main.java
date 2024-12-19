package com.mono_car_rent;

import java.awt.*;
import java.net.URL;
import java.util.Objects;

import javax.swing.*;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mono_car_rent.common.config.ConfigService;
import com.mono_car_rent.common.config.ConfigUpdateDTO;
import com.mono_car_rent.common.gui.Fonts;
import com.mono_car_rent.common.gui.Colors;
import com.mono_car_rent.common.gui.SideMenuPanel;
import com.mono_car_rent.modules.rental.rental.RentalGUI;

public class Main extends JFrame {
    private  final static ConfigService configService = ConfigService.getInstance();
    private JPanel mainPanel;
    private SideMenuPanel sideMenuPanel;
    private JPanel sidePanel;
    private JPanel contentPanel;
    private JButton menuToggler;
    private JLabel logoLabel;
    private JButton rentalsButton;
    private JLabel rentalsButtonLabel;
    private JButton customersButton;
    private JLabel customersButtonLabel;
    private JButton vehiclesButton;
    private JLabel vehiclesButtonLabel;
    private static final int maxSideMenuWidth = 160;
    private static final int minSideMenuWidth = 55;

    public Main() {
        // Initialize configs
        Colors.init();
        // Initialize components
        initComponents();
        sideMenuPanel.setMain(contentPanel);
        sideMenuPanel.setSide(sidePanel);
        sideMenuPanel.setMinWidth(minSideMenuWidth);
        sideMenuPanel.setMaxWidth(maxSideMenuWidth);
        sideMenuPanel.setMainAnimation(true);
        sideMenuPanel.setSpeed(4);
        sideMenuPanel.setResponsiveMinWidth(600);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        mainPanel = new JPanel();
        sideMenuPanel = new SideMenuPanel(this);
        logoLabel = new JLabel();
        menuToggler = new JButton();
        rentalsButton = new JButton();
        customersButton = new JButton();
        rentalsButtonLabel = new JLabel();
        customersButtonLabel = new JLabel();
        vehiclesButton = new JButton();
        vehiclesButtonLabel = new JLabel();
        sidePanel = new JPanel();
        contentPanel = new JPanel();
        // Setup main layout
        setupLayout();

        // Setup components
        setupComponents();
        setupActions();

        pack();
        setLocationRelativeTo(null);
    }

    private void setupLayout() {
        // Setup main layout
        setFont(Fonts.getFontRegularSM());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Side panel
        sidePanel.setBackground(Colors.getPrimaryColor());
        sidePanel.setPreferredSize(new Dimension(60, 32));
        GroupLayout sidePanelLayout = new GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
                sidePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(menuToggler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rentalsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vehiclesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
                sidePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(menuToggler, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rentalsButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customersButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vehiclesButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // Content pane
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(sidePanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidePanel, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }

    private void setupComponents() {
        // Setup logo
        this.setupLogo();

        // Setup buttons
        this.setupButtons();

        // Setup menu toggle
        this.setupMenuToggle();

        // Setup content panel
        this.navigateToRentals();
    }

    private void setupLogo() {
        URL url = this.getClass().getResource("/images/logo.png");
        ImageIcon icon = new ImageIcon(url);
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(50, GroupLayout.DEFAULT_SIZE, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(newimg));
        logoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        logoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        logoLabel.setForeground(Colors.getTextPrimaryColor());
        logoLabel.setFont(Fonts.getHeadersFontBoldXL());
        logoLabel.setMinimumSize(new Dimension(50, 50));
    }

    private void setupButtons() {
        this.setupMenuButton(rentalsButton);
        this.setupMenuButton(customersButton);
        this.setupMenuButton(vehiclesButton);
        rentalsButton.setIcon(this.buildSVGIcon("/icons/car-building.svg"));
        rentalsButton.setText("Rentals");
        rentalsButtonLabel.setForeground(Colors.getTextPrimaryColor());
        rentalsButtonLabel.setText("Rentals");
        customersButton.setIcon(this.buildSVGIcon("/icons/users.svg"));
        customersButton.setText("Customers");
        customersButtonLabel.setForeground(Colors.getTextPrimaryColor());
        customersButtonLabel.setText("Customers");
        vehiclesButton.setIcon(this.buildSVGIcon("/icons/car-garage.svg"));
        vehiclesButton.setText("Vehicles");
        vehiclesButtonLabel.setForeground(Colors.getTextPrimaryColor());
        vehiclesButtonLabel.setText("Vehicles");
    }

    private void setupMenuButton(JButton button) {
        button.setBackground(Colors.getPrimaryColor());
        button.setForeground(Colors.getTextPrimaryColor());
        button.setFont(Fonts.getHeadersFontBoldMD());
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setHideActionText(true);
        button.setHorizontalAlignment(SwingConstants.LEADING);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setIconTextGap(20);
        button.setMargin(new Insets(2, 3, 2, 14));
        button.setMinimumSize(new Dimension(0, 35));
        button.setPreferredSize(new Dimension(50, 35));
    }

    private void setupMenuToggle() {
        menuToggler.setIcon(this.buildSVGIcon("/icons/bars.svg"));
        this.setupMenuButton(menuToggler);
    }

    private FlatSVGIcon buildSVGIcon(String resourcePath) {
        URL url = Objects.requireNonNull(this.getClass().getResource(resourcePath));
        FlatSVGIcon svg = new FlatSVGIcon(url);
        return svg.derive(35, 35);
    }

    private void setupActions() {
        menuToggler.addActionListener(e -> this.onMenuToggle());
        rentalsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navigateToRentals();
            }
        });
        customersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navigateToCustomers();
            }
        });
        vehiclesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navigateToVehicles();
            }
        });
        boolean isSideMenuOpen = configService.getConfig().isSideMenuOpen();
        if (isSideMenuOpen) {
            sideMenuPanel.onSideMenu();
        }
    }

    private void onMenuToggle() {
        this.sideMenuPanel.onSideMenu();
        if (this.sideMenuPanel.getIsOpen()) {
            configService.update(new ConfigUpdateDTO().setIsSideMenuOpen(true));
        } else {
            configService.update(new ConfigUpdateDTO().setIsSideMenuOpen(false));
        }
    }

    private void navigateToCustomers() {
        //this.refreshContentPanelWith(new CustomerGUI().getMainPanel());
    }

    private void navigateToVehicles() {
        //this.refreshContentPanelWith(new VehicleGUI().getMainPanel());
    }

    private void navigateToRentals() {
        this.refreshContentPanelWith(new RentalGUI(this).getMainPanel());
    }

    private void refreshContentPanelWith(JPanel panel) {
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
