package Lab3;

import java.util.ArrayList;

public class Employee {
    public enum Gender {
        MALE,
        FEMALE
    }


    public enum Role {
        STAFF(10000, 10),
        MANAGER(15000, 20),
        EXECUTIVE(20000, 30);

        private double salary;
        private double prem;

        Role(double salary, double premPercent) {
            this.salary = salary;
            this.prem = premPercent;
        }

        public double getSalary() {
            return salary;
        }

        public double getPrem() {
            return prem;
        }
    }

    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    private Employee() {

    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Employee.Gender getGender() {
        return gender;
    }

    public Employee.Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "givenName='" + this.givenName + "'" +
                ", surName='" + this.surName + "'" +
                ", age='" + this.age + "'" +
                ", gender='" + this.gender + "'" +
                ", role='" + this.role + "'" +
                ", dept='" + this.dept + "'" +
                ", eMail='" + this.eMail + "'" +
                ", phone='" + this.phone + "'" +
                ", address='" + this.address + "'" +
                ", city='" + this.city + "'" +
                ", state='" + this.state + "'" +
                ", code='" + this.code + "'" + "}";
    }


    public static class Builder {
        private String givenName;
        private String surName;
        private int age;
        private Employee.Gender gender;
        private Employee.Role role;
        private String dept;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String code;

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(Employee.Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setRole(Employee.Role role) {
            this.role = role;
            return this;
        }

        public Builder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public Builder setEMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.givenName = this.givenName;
            employee.surName = this.surName;
            employee.age = this.age;
            employee.gender = this.gender;
            employee.role = this.role;
            employee.dept = this.dept;
            employee.eMail = this.eMail;
            employee.phone = this.phone;
            employee.address = this.address;
            employee.city = this.city;
            employee.state = this.state;
            employee.code = this.code;
            return employee;
        }
    }

    public static java.util.List<Employee> createShortList() {
        java.util.List<Employee> list = new ArrayList<>();
        list.add(new Builder().setGivenName("Oleg").setSurName("Ivanov").setAge(54).setGender(Gender.MALE)
                .setRole(Role.EXECUTIVE).setDept("IT").setEMail("oleg2021-54@yndex.ru").setPhone("88005553535")
                .setAddress("Ul.Kukushkina D3K1Kv69").setCity("Saratov").setState("Saratovskaya")
                .setCode("12345").build());
        list.add(new Builder().setGivenName("Vasiliy").setSurName("Pupkin").setAge(45).setGender(Gender.MALE)
                .setRole(Role.MANAGER).setDept("IT").setEMail("vPupkin@gmail.com").setPhone("89764697643")
                .setAddress("Ul.Pupkina D1K1Kv1").setCity("Pupkingrad").setState("Pupkinskaya")
                .setCode("54321").build());
        list.add(new Builder().setGivenName("Luba").setSurName("Nelubovna").setAge(30).setGender(Gender.FEMALE)
                .setRole(Role.MANAGER).setDept("PR").setEMail("n0l0v3@mail.com").setPhone("86544563322")
                .setAddress("Pr.Tapkina D45Kv15").setCity("Saratov").setState("Saratovskaya")
                .setCode("12345").build());
        list.add(new Builder().setGivenName("Ivan").setSurName("Kaktusov").setAge(25).setGender(Gender.MALE)
                .setRole(Role.STAFF).setDept("IT").setEMail("koluchiy@yandex.ru").setPhone("89762344678")
                .setAddress("Ul.Kukushkina D35Kv96").setCity("Saratov").setState("Saratovskaya")
                .setCode("12345").build());
        list.add(new Builder().setGivenName("Olga").setSurName("Petrova").setAge(28).setGender(Gender.FEMALE)
                .setRole(Role.STAFF).setDept("IT").setEMail("OP2882@mail.com").setPhone("89995553322")
                .setAddress("Ul.Tapkina D3K2Kv96").setCity("Saratov").setState("Saratovskaya")
                .setCode("12345").build());
        list.add(new Builder().setGivenName("Nikita").setSurName("Nosov").setAge(24).setGender(Gender.MALE)
                .setRole(Role.STAFF).setDept("PR").setEMail("NiNo@mail.com").setPhone("89654321145")
                .setAddress("Ul.Nesuschestvuyuschaya D14kv54").setCity("Pipkingrad").setState("Pupkinskaya")
                .setCode("54321").build());
        list.add(new Builder().setGivenName("Ekaterina").setSurName("Kataeva").setAge(35).setGender(Gender.FEMALE)
                .setRole(Role.STAFF).setDept("IT").setEMail("ekatkat@gmail.com").setPhone("86753245698")
                .setAddress("Ul.Tapkina D14K2Kv15").setCity("Saratov").setState("Saratovskaya")
                .setCode("12345").build());

        return list;
    }
}
