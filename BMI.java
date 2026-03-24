import javax.swing.*;
import java.awt.*;

public class BMI extends JFrame {
    private final JTextField height = new JTextField();
    private final JTextField weight = new JTextField();
    private final JLabel resultLabel = new JLabel("Enter Height, Weight and click Calculate");

    public BMI() {
        super("BMI Calculator");
        setLayout(new BorderLayout(8, 8));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 8, 8));
        formPanel.add(new JLabel("Height (cm):"));
        formPanel.add(height);
        formPanel.add(new JLabel("Weight (kg):"));
        formPanel.add(weight);
        add(formPanel, BorderLayout.NORTH);

        JButton calc = new JButton("Calculate");
        calc.addActionListener(e -> calculateBMI());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calc);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateBMI() {
        try {
            double h = Double.parseDouble(height.getText()) / 100.0;
            double w = Double.parseDouble(weight.getText());
            double bmi = w / (h * h);
            String result = bmi < 18.5 ? "Underweight"
                    : bmi < 25 ? "Normal"
                    : bmi < 30 ? "Overweight"
                    : "Obese";
            resultLabel.setText(String.format("        %s - BMI: %.2f", result, bmi));
        } catch (Exception ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMI::new);
    }
}


