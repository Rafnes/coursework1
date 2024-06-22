public class Employee {
    private final String name;
    private int department;
    private int salary;
    private final int id;
    private static int idCounter;

    public Employee(String name, int department, int salary) {
        this.name = name;
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        this.department = department;
        if (salary <= 0) {
            throw new IllegalArgumentException("Некорректная зарплата");
        }
        this.salary = salary;
        this.id = ++idCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getName() {
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
        if (salary <= 0) {
            System.out.println("Нельзя установить ЗП значение 0 или меньше");
            return;
        }
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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return this.id == employee.id && this.name.equals(employee.name) && this.salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, department, salary, id);
    }
}