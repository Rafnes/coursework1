public class App {
    public static void printAllEmployees(Employee[] employees) {
        System.out.println("Список всех сотрудников: ");
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            System.out.println(employees[i]);
        }
    }

    public static int getMonthlySalaryExpenses(Employee[] employees) {
        int total = 0;
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public static Employee getMinSalaryEmployee(Employee[] employees) {
        int min = employees[0].getSalary();
        Employee employeeMinSalary = employees[0];
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }

    public static Employee getMaxSalaryEmployee(Employee[] employees) {
        int max = employees[0].getSalary();
        Employee employeeMaxSalary = employees[0];
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }

    public static double getAverageSalaryExpenses(Employee[] employees) {
        return (double) getMonthlySalaryExpenses(employees) / employees.length;
    }

    public static void printAllEmployeeNames(Employee[] employees) {
        System.out.println("ФИО всех сотрудников: ");
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            System.out.println(employees[i].getName());
        }
    }

    public static int getEmployeesAmount(Employee[] employees) {
        int total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                total++;
            }
        }
        return total;
    }


    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Тымчук Алексей Владимирович", 1, 148000);
        employees[1] = new Employee("Корнеева Рената Анатольевна", 2, 90000);
        employees[2] = new Employee("Игнатьев Павел Евгеньевич", 1, 60000);
        employees[3] = new Employee("Марков Сергей Олегович", 4, 91000);
        employees[4] = new Employee("Семенова Екатерина Андреевна", 5, 100000);
        employees[5] = new Employee("Кузьмина Нина Александровна", 1, 160000);
        employees[6] = new Employee("Степанов Олег Павлович", 3, 110000);
        employees[7] = new Employee("Коршиков Игорь Александрович", 5, 44000);
        employees[8] = new Employee("Дроздов Николай Альбертович", 2, 72000);


        printAllEmployees(employees);

        System.out.println("Суммарно за месяц на ЗП тратится: " + getMonthlySalaryExpenses(employees));

        System.out.println("Сотрудник с минимальной зарплатой: " + getMinSalaryEmployee(employees));

        System.out.println("Сотрудник с максимальной зарплатой: " + getMaxSalaryEmployee(employees));

        System.out.println("Средняя зарплата: " + getAverageSalaryExpenses(employees));

        printAllEmployeeNames(employees);
    }
}
