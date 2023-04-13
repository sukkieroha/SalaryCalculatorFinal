import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class SalaryCalculatorGUI extends JFrame implements ActionListener {
    private JLabel firstNameLabel,lastNameLabel, birthdateLabel, employeeNumberLabel, hoursWorkedLabel, hourlyRateLabel,sssDeductionLabel,pagIbigDeductionLabel, philHealthDeductionLabel, taxDeductionLabel,totalDeductionsLabel,  grossSalaryLabel, netSalaryLabel;
    private JTextField firstNameField, lastNameField, birthdateField, employeeNumberField, hoursWorkedField, hourlyRateField,sssDeductionField,pagIbigDeductionField, philHealthDeductionField, taxDeductionField,totalDeductionsField, grossSalaryField, netSalaryField;
    private JButton calculateButton;

    public SalaryCalculatorGUI() {
        // Set up the form layout and components
        this.setTitle("Employee Salary Calculator");
        this.setLayout(new GridLayout(8, 2, 10, 10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);

        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        birthdateLabel = new JLabel("Employee Birthdate:");
        employeeNumberLabel = new JLabel("Employee Number:");
        hoursWorkedLabel = new JLabel("Hours Worked:");
        hourlyRateLabel = new JLabel("Hourly Rate:");
        sssDeductionLabel = new JLabel("-SSS:");
        philHealthDeductionLabel = new JLabel("-Phil Health:");
        pagIbigDeductionLabel = new JLabel("-PagIbig:");
        taxDeductionLabel = new JLabel("-Tax:");
        grossSalaryLabel = new JLabel("Gross Salary:");
        netSalaryLabel = new JLabel("Net Salary:");

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        birthdateField = new JTextField();
        employeeNumberField = new JTextField();
        hoursWorkedField = new JTextField();
        hourlyRateField = new JTextField();
        sssDeductionField = new JTextField();
        sssDeductionField.setEditable(false);
        philHealthDeductionField = new JTextField();
        philHealthDeductionField.setEditable(false);
        pagIbigDeductionField = new JTextField();
        pagIbigDeductionField.setEditable(false);
        taxDeductionField = new JTextField();
        taxDeductionField.setEditable(false);
        grossSalaryField = new JTextField();
        grossSalaryField.setEditable(false);
        netSalaryField = new JTextField();
        netSalaryField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Add the components to the form
        this.add(firstNameLabel);
        this.add(firstNameField);
        this.add(lastNameLabel);
        this.add(lastNameField);
        this.add(birthdateLabel);
        this.add(birthdateField);
        this.add(employeeNumberLabel);
        this.add(employeeNumberField);
        this.add(hoursWorkedLabel);
        this.add(hoursWorkedField);
        this.add(hourlyRateLabel);
        this.add(hourlyRateField);
        this.add(sssDeductionLabel);
        this.add(sssDeductionField);
        this.add(philHealthDeductionLabel);
        this.add(philHealthDeductionField);
        this.add(pagIbigDeductionLabel);
        this.add(pagIbigDeductionField);
        this.add(taxDeductionLabel);
        this.add(taxDeductionField);
        this.add(grossSalaryLabel);
        this.add(grossSalaryField);
        this.add(netSalaryLabel);
        this.add(netSalaryField);
        this.add(calculateButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Retrieve the values from the text fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String birthdate = birthdateField.getText();
        int employeeNumber = Integer.parseInt(employeeNumberField.getText());
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());


        // Create a new instance of the EmployeeSalaryCalculator class//
        Employee employee = new Employee(employeeNumber, firstName, lastName, birthdate);

        double grossSalary = hoursWorked * WeeklyPayCalculator.hourlyRate + WeeklyPayCalculator.riceAllowance + WeeklyPayCalculator.phoneAllowance + WeeklyPayCalculator.clothingAllowance;

        // Calculate the total deductions
        double sssDeduction = grossSalary * 0.1; // SSS deduction is 10% of the gross salary
        double philHealthDeduction = grossSalary * 0.030; // PhilHealth deduction is 3.5% of the gross salary
        double pagIbigDeduction = grossSalary * 0.02; // Pag-IBIG deduction is 2% of the gross salary
        double taxDeduction = grossSalary * 0.20;

        // Calculate the net weekly salary
        double netSalary = grossSalary-sssDeduction-philHealthDeduction-pagIbigDeduction-taxDeduction;

        // Update the text fields with the results
        hourlyRateField.setText(Double.toString(WeeklyPayCalculator.hourlyRate));
        sssDeductionField.setText(Double.toString(Double.parseDouble(String.valueOf(sssDeduction))));
        philHealthDeductionField.setText(Double.toString(Double.parseDouble(String.valueOf(philHealthDeduction))));
        pagIbigDeductionField.setText(Double.toString(Double.parseDouble(String.valueOf(pagIbigDeduction))));
        taxDeductionField.setText(Double.toString(Double.parseDouble(String.valueOf(taxDeduction))));
        grossSalaryField.setText(Double.toString(Double.parseDouble(String.valueOf(grossSalary))));
        netSalaryField.setText(Double.toString(Double.parseDouble(String.valueOf(netSalary))));
    }

    public static void main(String[] args) {
        new SalaryCalculatorGUI();
    }
}
