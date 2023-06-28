public class Knight extends GameChar{
    public static final int DEFAULT_HP = 24;

    public Knight() {
        super(8, 24, 22, PlayerType.KNIGHT, false);
    }

    @Override
    public int getDefaulthealth() {
        return DEFAULT_HP;
    }
}
