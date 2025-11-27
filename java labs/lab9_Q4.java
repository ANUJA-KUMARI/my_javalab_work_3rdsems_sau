import java.io.*;

// ---------------- EMPLOYEE CLASS ----------------
class Employee implements Serializable {
    String name;
    double salary;
    int year, month, day;

    Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary +
                ", joined=" + year + "-" + month + "-" + day + "}";
    }
}

// ---------------- MANAGER CLASS ----------------
class Manager extends Employee {
    Employee secretary;

    Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    void setSecretary(Employee e) {
        secretary = e;
    }

    public String toString() {
        return "Manager{name='" + name + "', salary=" + salary +
                ", joined=" + year + "-" + month + "-" + day +
                ", secretary=" + (secretary != null ? secretary.name : "None") +
                "}";
    }
}

// ---------------- MAIN CLASS (file must match this name) ----------------
public class lab9_Q4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Writing objects to a file
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("employee.dat"));

        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);

        boss.setSecretary(harry);

        out.writeObject(harry);
        out.writeObject(boss);
        out.close();

        // Reading objects back
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.dat"));

        Employee e1 = (Employee) in.readObject();
        Employee e2 = (Employee) in.readObject();
        in.close();

        System.out.println(e1);
        System.out.println(e2);
    }
}
