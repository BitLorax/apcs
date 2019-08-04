package inheritanceLab;

public class Driver {
    public static void main(String[] args) {
        Person bob = new Person(27, "Coach Bob");
        System.out.println(bob);

        Student lynne = new Student(16, "Lynne Brooke", "HS95129", 3);
        System.out.println(lynne);

        Teacher mrJava = new Teacher(34, "Duke Java", "Computer Science", 50000);
        System.out.println(mrJava);

        CollegeStudent ima = new CollegeStudent(18, "Ima Frosh", "UCB123", 20, "Lit", 2);
        System.out.println(ima);
    }
}
