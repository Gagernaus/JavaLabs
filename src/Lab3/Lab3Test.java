package Lab3;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab3Test {
    public static void main(String args[]) {
        List<Employee> empl = Employee.createShortList();
        for (int i = 0; i < empl.size(); ++i) {
            System.out.println(empl.get(i).toString());
        }
        Predicate<Employee> isFemale = employee -> employee.getGender().equals(Gender.gender.FEMALE);
        Predicate<Employee> inIT = employee -> employee.getDept().equals("IT");
        Predicate<Employee> inPR = employee -> employee.getDept().equals("PR");
        Predicate<Employee> olderThan30 = employee -> employee.getAge() > 30;
        Predicate<Employee> isManager = employee -> employee.getRole().equals(Employee.Role.MANAGER);
        Predicate<Employee> isStaff = employee -> employee.getRole().equals(Employee.Role.STAFF);
        Predicate<Employee> isExecutive = employee -> employee.getRole().equals(Employee.Role.EXECUTIVE);
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

        System.out.println();
        System.out.println("Lab4");
        System.out.println("Employees but anonymous");
        List<Employee> emplAnon = empl.stream().map(tmp -> {
            Employee employee = new Employee.Builder().setGivenName("Anon").setSurName("Incognito").setAge(tmp.getAge()).setGender(tmp.getGender())
                    .setRole(tmp.getRole()).setDept("Unknown").setEMail("incognitoAnon@idk.com").setPhone("Unknown")
                    .setAddress("Nowhere").setCity("Nocity").setState("Nostate")
                    .setCode("Nostatecode").build();
            return employee;
        }).collect(Collectors.toList());
        for (int i = 0; i < emplAnon.size(); ++i) {
            System.out.println(emplAnon.get(i));
        }
        System.out.println();
        System.out.println("Employees but 10 years older");
        List<Employee> emplIn10Years = empl.stream().peek(System.out::println).map(tmp -> {
            Employee employee = new Employee.Builder().setGivenName(tmp.getGivenName()).setSurName(tmp.getSurName()).setAge(tmp.getAge() + 10).setGender(tmp.getGender())
                    .setRole(tmp.getRole()).setDept(tmp.getDept()).setEMail(tmp.geteMail()).setPhone(tmp.getPhone())
                    .setAddress(tmp.getAddress()).setCity(tmp.getCity()).setState(tmp.getState())
                    .setCode(tmp.getCode()).build();
            return employee;
        }).collect(Collectors.toList());
        System.out.println();
        for (int i = 0; i < emplAnon.size(); ++i) {
            System.out.println(emplIn10Years.get(i));
        }
        System.out.println();
        System.out.println("First employee younger than 30");
        Employee firstYoungerThan20 = empl.stream().filter(emp -> emp.getAge() < 30).findFirst().get();
        System.out.println(firstYoungerThan20.toString());

        System.out.println();
        System.out.println("First employee from PR");
        Employee firstPR = empl.stream().filter(emp -> emp.getDept().equals("PR")).findFirst().get();
        System.out.println(firstPR.toString());

        System.out.println();
        System.out.println("Lazy 1");
        Employee test = empl.stream().peek(System.out::println).filter(tmp -> tmp.getDept().equals("IT")).peek(System.out::println)
                .filter(tmp -> tmp.getAge() < 50).peek(System.out::println).findFirst().get();
        System.out.println();
        System.out.println(test.toString());
        System.out.println();
        System.out.println("Lazy 2");
        List<Employee> emplIn10Years1 = empl.stream().peek(System.out::println).map(tmp -> {
            Employee employee = new Employee.Builder().setGivenName(tmp.getGivenName()).setSurName(tmp.getSurName()).setAge(tmp.getAge() + 10).setGender(tmp.getGender())
                    .setRole(tmp.getRole()).setDept(tmp.getDept()).setEMail(tmp.geteMail()).setPhone(tmp.getPhone())
                    .setAddress(tmp.getAddress()).setCity(tmp.getCity()).setState(tmp.getState())
                    .setCode(tmp.getCode()).build();
            return employee;
        }).peek(System.out::println).collect(Collectors.toList());
        System.out.println();
        for (int i = 0; i < emplAnon.size(); ++i) {
            System.out.println(emplIn10Years1.get(i));
        }

        System.out.println();
        System.out.println("Min");
        Employee youngest = empl.stream().min((Employee first, Employee second) -> {
            if (first.getAge() > second.getAge()) {
                return 1;
            } else if (first.getAge() < second.getAge()) return -1;
            else return 0;
        }).get();
        System.out.println("Youngest");
        System.out.println(youngest.toString());
        Employee shortestName = empl.stream().min((Employee first, Employee second) -> {
            if (first.getGivenName().length() > second.getGivenName().length()) {
                return 1;
            } else if (first.getGivenName().length() < second.getGivenName().length()) {
                return -1;
            } else return 0;
        }).get();
        System.out.println("Shortest name");
        System.out.println(shortestName.toString());

        System.out.println();
        System.out.println("Max");
        Employee oldest = empl.stream().max((Employee first, Employee second) -> {
            if (first.getAge() > second.getAge()) {
                return 1;
            } else if (first.getAge() < second.getAge()) return -1;
            else return 0;
        }).get();
        System.out.println("Oldest");
        System.out.println(oldest.toString());
        Employee longestName = empl.stream().max((Employee first, Employee second) -> {
            if (first.getGivenName().length() > second.getGivenName().length()) {
                return 1;
            } else if (first.getGivenName().length() < second.getGivenName().length()) {
                return -1;
            } else return 0;
        }).get();
        System.out.println("Longest name");
        System.out.println(longestName.toString());

        System.out.println();
        double averageAge = empl.stream().mapToInt(tmp -> {
            return tmp.getAge();
        }).average().getAsDouble();
        System.out.println("Average age = " + averageAge);
        double averageSalary = empl.stream().mapToDouble(tmp -> {
            return tmp.getSalary();
        }).average().getAsDouble();
        System.out.println("Average salary = " + averageSalary);

        System.out.println();
        int sumAge = empl.stream().mapToInt(tmp -> {
            return tmp.getAge();
        }).sum();
        System.out.println("Sum of ages = " + sumAge);
        double sumSalary = empl.stream().mapToDouble(tmp -> {
            return tmp.getSalary();
        }).sum();
        System.out.println("Sum salary = " + sumSalary);
    }
}
