package inheritanceLab;

public class Student extends Person {
    private String id;
    private int iq;

    public Student() {
        id = "";
        iq = -1;
    }
    public Student(int age, String name, String gender, String id, int iq) {
        super(age, name, gender);
        this.id = id;
        this.iq = iq;
    }
    @Override
    public String toString() {
        return super.toString() + " ID: " + id + " IQ: " + iq;
    }
    public String getId() {
        return id;
    }
    public int getIq() {
        return iq;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }
}
