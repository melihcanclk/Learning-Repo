public class Archer extends GameChar{
    public static final int DEFAULT_HP = 18;

    public Archer() {
        super(7, 18, 20, PlayerType.ARCHER, false);
    }

    @Override
    public int getDefaulthealth() {
        return DEFAULT_HP;
    }
}
