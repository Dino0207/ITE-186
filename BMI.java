import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class BMI{
    public static void main (String[] args){
    System.out.println("BMI Calculator");
    Scanner sc = new Scanner(System.in);
   
    System.out.print("\nInput your height in cm: ");
    Double a = sc.nextDouble();
    
    System.out.print("Input your weight in kg: ");
    Double b = sc.nextDouble(); 
    
    sc.close();
    double c = a/100;
    double d = b/(c * c);
    BigDecimal f = new BigDecimal(d).setScale(2,RoundingMode.HALF_DOWN);
    double z = f.doubleValue();

    if (z < 18.5){
    System.out.println("You are Underweight, your BMI is: "+ z);
        }
    else if (z < 25){
    System.out.println("You are normal, your BMI is "+ z);

        }
    else if (z < 30){
    System.out.println("You are overweight, your BMI is "+ z);
    }
    else{
    System.out.println("You are Obesse, your BMI is "+ z);
    }
    }
}


