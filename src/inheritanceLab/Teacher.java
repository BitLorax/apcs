package inheritanceLab;

public class Teacher extends Person {
    private String subject;
    private double salary;

    Teacher() {
        super();
        subject = "";
        salary = -1;
    }
    Teacher(int age, String name, String gender, String subject, double salary) {
        super(age, name, gender);
        this.subject = subject;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return super.toString() + " Subject: " + subject + " Salary: " + salary;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
