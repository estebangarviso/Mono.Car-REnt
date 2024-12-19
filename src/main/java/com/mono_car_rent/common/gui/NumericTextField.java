package com.mono_car_rent.common.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;



public class NumericTextField extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JButton decrementButton;
    private JButton incrementButton;
    private int minValue = Integer.MIN_VALUE;
    private int maxValue = Integer.MAX_VALUE;
    
    public NumericTextField() {
        setLayout(new BorderLayout());
        
        textField = new JTextField();
        decrementButton = new JButton("-");
        decrementButton.setToolTipText("Decrement");
        decrementButton.setFocusable(false);
        decrementButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        decrementButton.setFont(Fonts.getFontRegularXS());
        incrementButton = new JButton("+");
        incrementButton.setToolTipText("Increment");
        incrementButton.setFocusable(false);
        incrementButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        incrementButton.setFont(Fonts.getFontRegularXS());

        
        // Set button sizes
        Dimension buttonSize = new Dimension(20, 20);
        decrementButton.setPreferredSize(buttonSize);
        incrementButton.setPreferredSize(buttonSize);
        
        // Set minimum width for text field
        textField.setPreferredSize(new Dimension(60, 20));
        
        add(decrementButton, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
        add(incrementButton, BorderLayout.EAST);
        
        setupListeners();
    }
    
    private void setupListeners() {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent ev) {
                char c = ev.getKeyChar();
                if (!Character.isDigit(c) && c != '\b') {
                    ev.consume();
                }
            }
        });
        
        // Add document listener for manual text changes
        textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { handleChange(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { handleChange(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { handleChange(); }
            
            private void handleChange() {
                try {
                    getValue(); // Validate the input
                    textField.setForeground(java.awt.Color.BLACK);
                } catch (NumberFormatException e) {
                    textField.setForeground(java.awt.Color.RED);
                }
            }
        });
        
        incrementButton.addActionListener(e -> incrementValue());
        decrementButton.addActionListener(e -> decrementValue());
    }
    
    private void incrementValue() {
        try {
            int value = getValue();
            if (value < maxValue) {
                setValue(value + 1);
            }
        } catch (NumberFormatException e) {
            setValue(minValue);
        }
    }
    
    private void decrementValue() {
        try {
            int value = getValue();
            if (value > minValue) {
                setValue(value - 1);
            }
        } catch (NumberFormatException e) {
            setValue(minValue);
        }
    }
    
    public int getValue() {
        String text = textField.getText();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
    
    public void setValue(int value) {
        if (value < minValue) value = minValue;
        if (value > maxValue) value = maxValue;
        textField.setText(String.valueOf(value));
    }
    
    public void setMinValue(int min) {
        this.minValue = min;
        // Validate current value against new min
        try {
            int currentValue = getValue();
            if (currentValue < min) {
                setValue(min);
            }
        } catch (NumberFormatException e) {
            setValue(min);
        }
    }
    
    public void setMaxValue(int max) {
        this.maxValue = max;
        // Validate current value against new max
        try {
            int currentValue = getValue();
            if (currentValue > max) {
                setValue(max);
            }
        } catch (NumberFormatException e) {
            setValue(this.minValue);  // Fixed: using this.minValue instead of min
        }
    }
    
    public int getMinValue() {
        return minValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    public void setText(String text) {
        textField.setText(text);
    }
    
    public String getText() {
        return textField.getText();
    }

    public void addActionListener(java.awt.event.ActionListener listener) {
        incrementButton.addActionListener(listener);
        decrementButton.addActionListener(listener);
    }
}
