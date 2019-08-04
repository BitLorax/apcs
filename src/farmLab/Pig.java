package farmLab;

public class Pig extends Animal {
    private String myType;
    private String mySound;

    public Pig()
    {
        myType = "pig";
        mySound = "oink";
    }

    public String getSound()
    {
        return mySound;
    }

    public String getType()
    {
        return myType;
    }
}
