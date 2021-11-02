package Lab3;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lab3Test {
    public static void main(String args[]) {
        List<Employee> empl = Employee.createShortList();
        for (int i = 0; i < empl.size(); ++i) {
            System.out.println(empl.get(i).toString());
        }
        Predicate<Employee> isFemale = employee -> employee.getGender() == Employee.Gender.FEMALE;
        Predicate<Employee> inIT = employee -> employee.getDept() == "IT";
        Predicate<Employee> inPR = employee -> employee.getDept() == "PR";
        Predicate<Employee> olderThan30 = employee -> employee.getAge() > 30;
        Predicate<Employee> isManager = employee -> employee.getRole() == Employee.Role.MANAGER;
        Predicate<Employee> isStaff = employee -> employee.getRole() == Employee.Role.STAFF;
        Predicate<Employee> isExecutive = employee -> employee.getRole() == Employee.Role.EXECUTIVE;
        System.out.println();
        empl.stream().filter(isFemale).forEach(Accountant::payPremium);
        System.out.println();
        empl.stream().filter(inPR).forEach(Accountant::paySalary);
        System.out.println();
        empl.stream().filter(inIT).filter(olderThan30).forEach(Accountant::payPremium);
        System.out.println();
        empl.stream().filter(isManager).forEach(Accountant::paySalary);
        System.out.println();
        empl.stream().filter(isStaff).forEach(Accountant::payPremium);
        System.out.println();
    }
}
