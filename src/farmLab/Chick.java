package farmLab;

public class Chick extends Animal {
    private String myType;
    private String[] mySounds = {"cheep", "cluck"};
    private boolean twoSounds;

    public Chick()
    {
        myType = "chick";
        this.twoSounds = false;
    }
    public Chick(boolean twoSounds)
    {
        myType = "chick";
        this.twoSounds = twoSounds;
    }

    public String getSound()
    {
        if (twoSounds) return mySounds[(int)(Math.random() * 2)];
        return mySounds[0];
    }

    public String getType()
    {
        return myType;
    }
}
