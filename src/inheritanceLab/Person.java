package inheritanceLab;

public class Person {
    private int age;
    private String name;
    private String gender;

    public Person() {
        age = -1; name = "";
    }
    public Person(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Name: " + name + " Age: " + age + " Gender: " + gender;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getGender() { return gender; }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) { this.gender = gender; }
}
