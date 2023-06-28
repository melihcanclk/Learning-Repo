public class Vampire extends Obstacle{
    public Vampire() {
        super(4, 14, 0, PlayerType.VAMPIRE, true);
    }

    @Override
    public int getDefaulthealth() {
        return 14;
    }
}
