package learning_oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator = "";
    private double num1 = 0, num2 = 0, result = 0;

    public calculator() {
        setTitle("Bro's Java Calculator");
        setSize(380, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
      
        getContentPane().setBackground(new Color(30, 30, 30));

        display = new JTextField("0"); // Shuru mein 0 show hoga
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(15, 15, 15));
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 8, 8));
        panel.setBackground(new Color(30, 30, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttons = {
                "C", "±", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "−",
                "1", "2", "3", "+",
                "0", ".", "=",
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder());

            // Colors styling
            if (text.equals("C") || text.equals("±") || text.equals("%")) {
                btn.setBackground(new Color(166, 166, 166));
                btn.setForeground(Color.BLACK);
            } else if (text.equals("÷") || text.equals("×") || text.equals("−") ||
                    text.equals("+") || text.equals("=")) {
                btn.setBackground(new Color(255, 149, 0));
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(51, 51, 51));
                btn.setForeground(Color.WHITE);
            }

            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.matches("[0-9.]")) {
                if (display.getText().equals("0") && !command.equals(".")) {
                    display.setText(command);
                } else {
                    display.setText(display.getText() + command);
                }
            } else if (command.equals("C")) {
                display.setText("0");
                operator = "";
                num1 = num2 = 0;
            } else if (command.equals("±")) {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(-val));
            } else if (command.equals("%")) {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(val / 100));
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "−":
                        result = num1 - num2;
                        break;
                    case "×":
                        result = num1 * num2;
                        break;
                    case "÷":
                        if (num2 == 0)
                            throw new ArithmeticException();
                        result = num1 / num2;
                        break;
                }
                display.setText(String.valueOf(result));
                operator = "";
            } else {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("0");
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new calculator().setVisible(true);
        });
    }
}