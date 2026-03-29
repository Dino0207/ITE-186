import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.regex.Pattern;

public class PasswordCheckerGUI {

public static void main(String[] args) {  

    JFrame frame = new JFrame("Password Strength Checker");  
    frame.setSize(400, 300);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setLayout(new FlowLayout());  

    JLabel label = new JLabel("Enter Password:");  
    JTextField passwordField = new JTextField(20);  
    JButton checkButton = new JButton("Check Strength");  
    JTextArea resultArea = new JTextArea(8, 30);  

    resultArea.setEditable(false);  

    frame.add(label);  
    frame.add(passwordField);  
    frame.add(checkButton);  
    frame.add(resultArea);  

    checkButton.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  

            String pwd = passwordField.getText().trim();  

            if (pwd.isEmpty()) {  
                resultArea.setText("Error: No password entered!");  
                return;  
            } 

            StringBuilder result = new StringBuilder();  
            result.append("Password: ").append(pwd).append("\n");  

            // Length check — must be at least 8 characters  
            String l = (pwd.length() >= 8) ? "✔ Length OK" :  "✘ Too short";
            result.append(l+"\n");
            

            // Number check  
            String nc = (Pattern.compile("[0-9]").matcher(pwd).find()) ? "✔ Has number" : "✘ No number";
            result.append(nc+"\n");

            // Symbol check  
            String sc = (Pattern.compile("^\\w\\s").matcher(pwd).find()) ? "✔ Has symbol" : "✘ No symbol";
            result.append(sc+"\n");
            
            resultArea.setText(result.toString());     
        }  
    });  

    frame.setVisible(true);  
}
}