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


        Employee.printAllEmployees(employees);

        System.out.println("Суммарно за месяц на ЗП тратится: " + Employee.getMonthlySalaryExpenses(employees));

        System.out.println("Сотрудник с минимальной зарплатой: " + Employee.getMinSalaryEmployee(employees));

        System.out.println("Сотрудник с максимальной зарплатой: " + Employee.getMaxSalaryEmployee(employees));

        System.out.println("Средняя зарплата: " + Employee.getAverageSalaryExpenses(employees));

        System.out.println("ФИО всех сотрудников: ");
        Employee.printAllEmployeeNames(employees);
    }
}
