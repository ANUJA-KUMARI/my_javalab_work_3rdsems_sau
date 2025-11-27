// lab3.java

class Person {
    private String name;
    private String gender;
    private String birthday;

    public Person(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return name.equals(person.name) &&
               gender.equals(person.gender) &&
               birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + gender.hashCode() + birthday.hashCode();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Birthday: " + birthday;
    }
}


class Organization {
    private String orgName;
    private int numEmployees;

    public Organization(String orgName) {
        this.orgName = orgName;
        this.numEmployees = 0;
    }

    public String getOrgName() {
        return orgName;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void addEmployee() {
        numEmployees++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  
        if (obj == null || getClass() != obj.getClass()) return false;

        Organization org = (Organization) obj;
        return orgName.equals(org.orgName);
    }

    @Override
    public int hashCode() {
        return orgName.hashCode();
    }

    @Override
    public String toString() {
        return "Organization: " + orgName + ", Number of Employees: " + numEmployees;
    }
}


class Employee extends Person {
    private String jobTitle;
    private Organization organization;

    public Employee(String name, String gender, String birthday, String jobTitle, Organization organization) {
        super(name, gender, birthday);
        this.jobTitle = jobTitle;
        this.organization = organization;
        this.organization.addEmployee();  // increase employee count when added
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Organization getOrganization() {
        return organization;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Employee)) return false;

        Employee emp = (Employee) obj;
        return jobTitle.equals(emp.jobTitle) &&
               organization.equals(emp.organization);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + jobTitle.hashCode() + organization.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Job Title: " + jobTitle +
               ", Organization: " + organization.getOrgName();
    }
}


public class lab3 {
    public static void main(String[] args) {
        // Create organizations
        Organization google = new Organization("Google");
        Organization microsoft = new Organization("Microsoft");

        // Create employees
        Employee e1 = new Employee("Alice", "Female", "1995-06-15", "Software Engineer", google);
        Employee e2 = new Employee("Bob", "Male", "1990-03-20", "Product Manager", microsoft);
        Employee e3 = new Employee("Alice", "Female", "1995-06-15", "Software Engineer", google);

        // Print employees
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        // Compare employees
        System.out.println("\nComparisons:");
        System.out.println("e1 equals e2? " + e1.equals(e2));
        System.out.println("e1 equals e3? " + e1.equals(e3));

        // Compare organizations
        System.out.println("\nOrganizations:");
        System.out.println(google);
        System.out.println(microsoft);
        System.out.println("Google equals Microsoft? " + google.equals(microsoft));
    }
}
