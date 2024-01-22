package JavaDevKit.lesson_4;

import java.util.ArrayList;
import java.util.List;

public class HW4 {
    public static void main(String[] args) {
        // коллекция сотрудников
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", "89148484214", 5));

        // сотрудник с двумя номерами
        Employee employee = new Employee("Mike", "891484845432", 1);
        employee.addPhoneNumber("891567845434");
        employeeList.add(employee);

        // Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
        EmployeeDirectory directory = new EmployeeDirectory(employeeList);

        // Добавить метод добавление нового сотрудника в справочник
        directory.addEmployeeToDirectory(new Employee("Kevin", "89148489876", 2));
        directory.addEmployeeToDirectory(new Employee("Albert", "89148487483", 3));
        directory.addEmployeeToDirectory(new Employee("Christian", "89148480295", 4));

        // Добавить метод, который ищет сотрудника по стажу (может быть список)
        System.out.println(directory.getListEmployeeByExperience(3));
        // Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
        System.out.println(directory.getPhoneNumberByNameEmployee("Mike"));
        // Добавить метод, который ищет сотрудника по табельному номеру
        System.out.println(directory.getEmployeeByPersonnelNumber(2));

    }
}


class EmployeeDirectory {
    private List<Employee> employeeList;

    public EmployeeDirectory(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     * Добавить метод, который ищет сотрудника по стажу (может быть список)
     *
     * @param experience стаж
     * @return список сотрудников
     */
    public List<Employee> getListEmployeeByExperience(int experience) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : this.employeeList) {
            if (employee.getExperience() == experience) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    /**
     * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
     *
     * @param name имя сотрудника
     * @return список номеров
     */
    public List<String> getPhoneNumberByNameEmployee(String name) {
        for (Employee employee : this.employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee.getPhoneNumber();
            }
        }
        return null;
    }

    /**
     * Добавить метод, который ищет сотрудника по табельному номеру
     *
     * @param personnelNumber табельный номер сотрудника
     * @return сотрудник
     */
    public Employee getEmployeeByPersonnelNumber(int personnelNumber) {
        for (Employee employee : this.employeeList) {
            if (employee.getPersonnelNumber() == personnelNumber) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Добавить метод добавление нового сотрудника в справочник
     *
     * @param employee сотрудник
     */
    public void addEmployeeToDirectory(Employee employee) {
        this.employeeList.add(employee);
    }

}

class Employee {
    static int employeePersonnelNumbers = 0;
    private String name;
    private int personnelNumber;
    private List<String> phoneNumber;
    private int experience;

    public Employee(String name, String phoneNumber, int experience) {
        this.phoneNumber = new ArrayList<>();
        this.personnelNumber = employeePersonnelNumbers++;
        this.name = name;
        this.phoneNumber.add(phoneNumber);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void addPhoneNumber(String number) {
        this.phoneNumber.add(number);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", personnelNumber=" + personnelNumber +
                ", phoneNumber=" + phoneNumber +
                ", experience=" + experience +
                '}';
    }
}

