import java.util.Scanner;
import javax.swing.SwingUtilities;
class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private String birthdate;

    public Employee(int employeeNumber, String firstName, String lastName, String birthdate) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;

    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}

class WeeklyPayCalculator {
    static double hourlyRate;
    static double riceAllowance;
    static double phoneAllowance;
    static double clothingAllowance;
    private static final double sssDeduction = 0.03;
    private static final double pagIbigDeduction = 0.02;
    private static final double philHealthDeduction = 0.03;
    private static final double taxDeduction = 0.12;
    public WeeklyPayCalculator(double hourlyRate,double riceAllowance,
                               double phoneAllowance,double clothingAllowance) {
        this.hourlyRate = hourlyRate;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;

    }
    public static double calculateGrossSalary(double hoursWorked, double hourlyRate) {
        return hoursWorked + hourlyRate;
    }
    public static double calculateNetSalary(double hoursWorked, double hourlyRate) {
        double grossSalary = calculateGrossSalary(hoursWorked, hourlyRate);
        double totalDeductions = (grossSalary * sssDeduction) + (grossSalary * pagIbigDeduction) + (grossSalary * philHealthDeduction) + (grossSalary * taxDeduction);
        return grossSalary - totalDeductions;
    }

}

public class SalaryCalculator {
    public static void main(String[] args) {

        // Create an instance of the SalaryCalculatorGUI class and display it
        SwingUtilities.invokeLater(() -> {
            SalaryCalculatorGUI gui = new SalaryCalculatorGUI();
            gui.setVisible(true);
        });

        Scanner scanner = new Scanner(System.in);

        // Create an instance of Employee with existing details
        Employee employee = new Employee(10001, "John", "Doe", "01/01/1990");

        // Create an instance of WeeklyPayCalculator with employee and allowance details
        WeeklyPayCalculator calculator = new WeeklyPayCalculator(300, 500, 1000, 200);

        // Prompt user to enter first name, last name and number of hours worked
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter number of hours worked: ");
        double hoursWorked = scanner.nextDouble();
        System.out.print("Enter number of hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        // Calculate the gross weekly salary

        double grossSalary = hoursWorked * hourlyRate;

        // Calculate the total deductions
        double sssDeduction = grossSalary * 0.1; // SSS deduction is 10% of the gross salary
        double philHealthDeduction = grossSalary * 0.030; // PhilHealth deduction is 3.5% of the gross salary
        double pagIbigDeduction = grossSalary * 0.02; // Pag-IBIG deduction is 2% of the gross salary
        double taxDeduction = grossSalary * 0.20;

        //calculate total deductions//
        double totalDeductions = (grossSalary * sssDeduction) + (grossSalary * pagIbigDeduction) + (grossSalary * philHealthDeduction) + (grossSalary * taxDeduction);
        // Calculate the net weekly salary
        double netSalary = grossSalary - totalDeductions;

        // Display the results
        System.out.println("Employee Number" + employee);
        System.out.println("Number of hours worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Gross salary: " + grossSalary);
        System.out.println("- SSS: " + sssDeduction);
        System.out.println("-PhilHealth: " + philHealthDeduction);
        System.out.println("-Pag-IBIG : " + pagIbigDeduction);
        System.out.println("-Tax: " + taxDeduction);
        System.out.println("- Total deductions: ");
        System.out.println("Net salary: " + netSalary);
    }
}
