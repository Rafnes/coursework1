public class App {
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

        indexSalaries(employees, 10);
        printAllEmployees(employees);
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2: " + getMinSalaryEmployeeInDept(employees, 2));
        System.out.println("Сотрудник с минимальной зарплатой в отделе 1: " + getMinSalaryEmployeeInDept(employees, 1));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 1: " + getMaxSalaryEmployeeInDept(employees, 1));
        System.out.println("Средняя зарплата по отделу 1: " + getAverageSalaryExpensesInDept(employees, 1));

        indexSalariesInDept(employees, 1, 10);
        System.out.println("Отдел 1 после индексации на 10 процентов: ");
        printEmployeesInDept(employees, 1);
        System.out.println("Сотрудники с ЗП меньше 100 000:");
        printAllEmployees(getEmployeesWithLowerSalaries(employees, 100000));
        System.out.println("Сотрудники с ЗП больше или равной 100 000:");
        printAllEmployees(getEmployeesWithHigherSalaries(employees, 100000));

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

    public static void printAllEmployees(Employee[] employees) {
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i] == null) {
                continue;
            }
            System.out.println(employees[i]);
        }
    }

    public static int getMonthlySalaryExpenses(Employee[] employees) {
        int total = 0;
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i] == null) {
                continue;
            }
            total += employees[i].getSalary();
        }
        return total;
    }

    public static Employee getMinSalaryEmployee(Employee[] employees) {
        Employee employeeMinSalary = employees[0];
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i].getSalary() < employeeMinSalary.getSalary()) {
                employeeMinSalary = employees[i];
            }
        }
        return employeeMinSalary;
    }

    public static Employee getMaxSalaryEmployee(Employee[] employees) {
        Employee employeeMaxSalary = employees[0];
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i].getSalary() > employeeMaxSalary.getSalary()) {
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }

    public static double getAverageSalaryExpenses(Employee[] employees) {
        return (double) getMonthlySalaryExpenses(employees) / getEmployeesAmount(employees);
    }

    public static void printAllEmployeeNames(Employee[] employees) {
        System.out.println("ФИО всех сотрудников: ");
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i] == null) {
                continue;
            }
            System.out.println(employees[i].getName());
        }
    }

    public static void indexSalaries(Employee[] employees, int percent) {
        if (percent <= 0) {
            throw new IllegalArgumentException("Процент должен быть больше 0");
        }
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            int increasedSalary = (int) (employees[i].getSalary() + (double) employees[i].getSalary() * percent / 100);
            employees[i].setSalary(increasedSalary);
        }
    }

    public static Employee getMinSalaryEmployeeInDept(Employee[] employees, int department) {
        Employee[] employeesInDept = getEmployeesInDept(employees, department);
        return getMinSalaryEmployee(employeesInDept);
    }

    public static Employee getMaxSalaryEmployeeInDept(Employee[] employees, int department) {
        Employee[] employeesInDept = getEmployeesInDept(employees, department);
        return getMaxSalaryEmployee(employeesInDept);
    }

    public static Employee[] getEmployeesInDept(Employee[] employees, int department) {
        Employee[] employeesInDept = new Employee[getEmployeesAmount(employees)];
        int counter = 0;
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (department == employees[i].getDepartment()) {
                employeesInDept[counter] = employees[i];
                counter++;
            }
        }
        return employeesInDept;
    }

    public static void printEmployeesInDept(Employee[] employees, int department) {
        Employee[] employeesInDept = getEmployeesInDept(employees, department);
        for (int i = 0; i < getEmployeesAmount(employeesInDept); i++) {
            String string = String.format("%s, id: %s, зарплата: %s", employeesInDept[i].getName(), employeesInDept[i].getID(), employeesInDept[i].getSalary());
            System.out.println(string);
        }
    }

    public static double getAverageSalaryExpensesInDept(Employee[] employees, int department) {
        Employee[] employeesInDept = getEmployeesInDept(employees, department);
        return getAverageSalaryExpenses(employeesInDept);
    }

    public static void indexSalariesInDept(Employee[] employees, int department, int percent) {
        if (percent <= 0) {
            throw new IllegalArgumentException("Процент должен быть больше 0");
        }
        Employee[] employeesInDept = getEmployeesInDept(employees, department);
        indexSalaries(employeesInDept, percent);
    }

    public static Employee[] getEmployeesWithLowerSalaries(Employee[] employees, int targetSalary) {
        Employee[] employeesTarget = new Employee[getEmployeesAmount(employees)];
        int count = 0;
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getSalary() < targetSalary) {
                employeesTarget[count] = employees[i];
                count++;
            }
        }
        return employeesTarget;
    }

    public static Employee[] getEmployeesWithHigherSalaries(Employee[] employees, int targetSalary) {
        Employee[] employeesTarget = new Employee[getEmployeesAmount(employees)];
        int count = 0;
        for (int i = 0; i < getEmployeesAmount(employees); i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getSalary() >= targetSalary) {
                employeesTarget[count] = employees[i];
                count++;
            }
        }
        return employeesTarget;
    }
}