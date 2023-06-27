public class Samurai extends GameChar {
    public static final int DEFAULT_HP = 21;

    public Samurai() {
        super(5, 21, 15, PlayerType.SAMURAI, false);
    }

    @Override
    public int getDefaulthealth() {
        return DEFAULT_HP;
    }
}
