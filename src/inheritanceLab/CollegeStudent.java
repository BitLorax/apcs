package inheritanceLab;

public class CollegeStudent extends Student {
    private String major;
    private int year;

    public CollegeStudent(int age, String name, String id, String gender, int iq, String major, int year) {
        super(age, name, gender, id, iq);
        this.major = major;
        this.year = year;
    }
    @Override
    public String toString() {
        return super.toString() + " Major: " + major + " Year: " +  year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
