public class Employee {
    private final String name;
    private int department;
    private int salary;
    private final int id;
    private static int idCounter;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = ++idCounter;
    }

    public String getFirstName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getID() {
        return id;
    }

    public void setDepartment(int department) {
        if (department <= 0 || department > 5) {
            System.out.println("Некорректный номер отдела");
            return;
        }
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s, id: %s, отдел: %s, зарплата %s", name, id, department, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        }
        Employee employee = (Employee) obj;
        return this.id == employee.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, department, salary, id);
    }

    public static void printAllEmployees(Employee[] employees) {
        System.out.println("Список всех сотрудников: ");
        for (int i = 0; i < idCounter; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int getMonthlySalaryExpenses(Employee[] employees) {
        int total = 0;
        for (int i = 0; i < employees.length - 1; i++) {
            total += employees[i].salary;
        }
        return total;
    }

    public static Employee getMinSalaryEmployee(Employee[] employees) {
        int min = 1_000_000_000;
        int minSalaryIndex = 0;
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i].salary < min) {
                min = employees[i].salary;
                minSalaryIndex = i;
            }
        }
        return employees[minSalaryIndex];
    }

    public static Employee getMaxSalaryEmployee(Employee[] employees) {
        int max = 0;
        int maxSalaryIndex = 0;
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i].salary > max) {
                max = employees[i].salary;
                maxSalaryIndex = i;
            }
        }
        return employees[maxSalaryIndex];
    }

    public static double getAverageSalaryExpenses(Employee[] employees) {
        return (double) getMonthlySalaryExpenses(employees) / employees.length;
    }

    public static void printAllEmployeeNames(Employee[] employees) {
        for (int i = 0; i < employees.length - 1; i++) {
            System.out.println(employees[i].name);
        }
    }
}