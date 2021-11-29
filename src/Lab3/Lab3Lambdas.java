package Lab3;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Lab3Lambdas {
    public static void main(String args[]) {
        List<Employee> empl = Employee.createShortList();
        for (int i = 0; i < empl.size(); ++i) {
            System.out.println(empl.get(i).toString());
        }
        Predicate<Employee> isFemale = employee -> employee.getGender().equals(Gender.gender.FEMALE);
        Predicate<Employee> inIT = employee -> employee.getDept() == "IT";
        Predicate<Employee> inPR = employee -> employee.getDept() == "PR";
        Predicate<Employee> olderThan30 = employee -> employee.getAge() > 30;
        Predicate<Employee> isManager = employee -> employee.getRole().equals(Employee.Role.MANAGER);
        Predicate<Employee> isStaff = employee -> employee.getRole().equals(Employee.Role.STAFF);
        Predicate<Employee> isExecutive = employee -> employee.getRole().equals(Employee.Role.EXECUTIVE);
        System.out.println();
        Consumer<Employee> paySalary = employee -> System.out.println("Paid salary to " + employee.toString());
        System.out.println("Consumer paying salaries");
        empl.stream().filter(isFemale).forEach(paySalary);
        System.out.println();
        Function<Employee, String> getFullName = employee -> employee.getGivenName() + " " + employee.getSurName();
        System.out.println("Function getting full names");
        empl.stream().forEach(employee -> System.out.println(getFullName.apply(employee)));
        Supplier<Employee> randomEmployee = () -> new Employee.Builder().setAge((int) (Math.random() * 100))
                .setGivenName(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setSurName(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setAddress(new Random().ints(97, 123).limit(5).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setCity(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setCode(new Random().ints(48, 59).limit(5).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setEMail(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString() + "@yandex.ru")
                .setDept(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setState(new Random().ints(97, 123).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setPhone(new Random().ints(48, 59).limit(10).
                        collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .setGender(Gender.gender.values()[(int) (Math.random() * 2)])
                .setRole(Employee.Role.values()[(int) (Math.random() * 3)]).build();
        System.out.println();
        System.out.println("Supplier making random Employees");
        System.out.println(randomEmployee.get().toString());
        System.out.println();
        BiPredicate<Employee, String> livesInCity = (employee, sting) -> employee.getCity().equals(sting);
        String n = "Saratov";
        System.out.println("BiPredicate to find employees living in certain city 'n' = " + n);
        for (int i = 0; i < empl.size(); ++i) {
            if (livesInCity.test(empl.get(i), n)) {
                System.out.println(empl.get(i).toString() + " lives in city " + n);
            }
        }
    }
}
