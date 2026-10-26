package lld.patterns.composite;

public class Employee implements OrgComponent {
    private String name;
    private String title;
    private int salary;

    public Employee(String name, String title, int salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getHeadCount() {
        return 1;
    }

    @Override
    public void printHierarchy(String indent) {
        System.out.println(indent + "- " + name + " (" + title + ", $" + salary + ")");
    }
}
