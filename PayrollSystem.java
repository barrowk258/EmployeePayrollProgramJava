import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class PayrollSystem {

    static class EmployeeRecord {
        String firstName;
        String lastName;
        String employeeId;
        double hours;
        double rate;
        double grossPay;
        double deductions;
        double netPay;
        LocalDateTime date;

        EmployeeRecord(String firstName, String lastName, String employeeId,
                       double hours, double rate, double deductions) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.employeeId = employeeId;
            this.hours = hours;
            this.rate = rate;
            this.deductions = deductions;
            this.grossPay = hours * rate;
            this.netPay = grossPay - deductions;
            this.date = LocalDateTime.now();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<EmployeeRecord> employeeRecords = new ArrayList<>();

        String addAnother = "yes";

        while (addAnother.equalsIgnoreCase("yes")) {
            System.out.print("Enter employee first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter employee last name: ");
            String lastName = input.nextLine();

            System.out.print("Enter employee ID: ");
            String employeeId = input.nextLine();

            System.out.print("Enter hours worked: ");
            double hours = input.nextDouble();

            System.out.print("Enter hourly rate: ");
            double rate = input.nextDouble();

            System.out.print("Enter deductions: ");
            double deductions = input.nextDouble();
            input.nextLine();

            EmployeeRecord employee = new EmployeeRecord(
                    firstName, lastName, employeeId, hours, rate, deductions
            );

            employeeRecords.add(employee);

            displayEmployeeRecord(employee);

            System.out.print("Would you like to add another employee? yes/no: ");
            addAnother = input.nextLine();
        }

        displayAllEmployees(employeeRecords);

        input.close();
    }

    public static void displayEmployeeRecord(EmployeeRecord employee) {
        System.out.println("\nEmployee Payroll Record");
        System.out.println("------------------------");
        System.out.println("Name: " + employee.firstName + " " + employee.lastName);
        System.out.println("Employee ID: " + employee.employeeId);
        System.out.printf("Hours Worked: %.2f%n", employee.hours);
        System.out.printf("Hourly Rate: $%.2f%n", employee.rate);
        System.out.printf("Gross Pay: $%.2f%n", employee.grossPay);
        System.out.printf("Deductions: $%.2f%n", employee.deductions);
        System.out.printf("Net Pay: $%.2f%n", employee.netPay);
        System.out.println("Date: " + employee.date);
        System.out.println();
    }

    public static void displayAllEmployees(ArrayList<EmployeeRecord> employeeRecords) {
        System.out.println("\nAll Employee Payroll Records");
        System.out.println("============================");

        for (EmployeeRecord employee : employeeRecords) {
            displayEmployeeRecord(employee);
        }

        System.out.println("Total employees processed: " + employeeRecords.size());
    }
}