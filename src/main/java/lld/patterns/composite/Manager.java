package lld.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements OrgComponent {
    private String name;
    private String title;
    private int salary;
    private List<OrgComponent> employees;

    public Manager(String name, String title, int salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(OrgComponent employee) {
        this.employees.add(employee);
    }

    @Override
    public int getSalary() {
        int salary = this.salary;

        for (int i = 0; i < this.employees.size(); i++) {
            salary += this.employees.get(i).getSalary();
        }
        return salary;
    }

    @Override
    public int getHeadCount() {
        int headCount = 1;

        for (int i = 0; i < this.employees.size(); i++) {
            headCount += this.employees.get(i).getHeadCount();
        }

        return headCount;
    }

    @Override
    public void printHierarchy(String indent) {
        System.out.println(indent + "+ " + this.name + " (" + this.title + ", $" + this.salary + ")");
        for (int i = 0; i < this.employees.size(); i++) {
            this.employees.get(i).printHierarchy(indent + " ");
        }
    }

    static void main() {
        Employee dev1 = new Employee("Alice", "Senior Engineer", 120000);
        Employee dev2 = new Employee("Bob", "Engineer", 95000);
        Employee dev3 = new Employee("Charlie", "Engineer", 90000);
        Employee designer = new Employee("Diana", "Designer", 100000);

        Manager techLead = new Manager("Eve", "Tech Lead", 140000);
        techLead.addEmployee(dev1);
        techLead.addEmployee(dev2);

        Manager vpEng = new Manager("Frank", "VP Engineering", 200000);
        vpEng.addEmployee(techLead);
        vpEng.addEmployee(dev3);

        Manager vpProduct = new Manager("Grace", "VP Product", 190000);
        vpProduct.addEmployee(designer);

        Manager ceo = new Manager("Hank", "CEO", 300000);
        ceo.addEmployee(vpEng);
        ceo.addEmployee(vpProduct);

        System.out.println("---- Organization Chart ----");
        ceo.printHierarchy("");

        System.out.println("\nTotal Payroll: $" + ceo.getSalary());
        System.out.println("Total Headcount: " + ceo.getHeadCount());
        System.out.println("\nEngineering Payroll: $" + vpEng.getSalary());
        System.out.println("Engineering Headcount: " + vpEng.getHeadCount());
    }
}
