package farmLab;

public class NamedCow extends Cow {
    private String name;

    public NamedCow(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
