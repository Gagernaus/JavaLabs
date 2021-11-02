package Lab3;

public class Accountant {
    public static void paySalary(Employee employee) {
        System.out.println("Paid salary to employee " + employee.toString());
    }

    public static void payPremium(Employee employee) {
        System.out.println("Paid " + employee.getRole().getPrem() + "% premium to employee " + employee.toString());
    }
}
