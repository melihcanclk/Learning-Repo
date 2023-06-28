public class Bear extends Obstacle{
    public Bear() {
        super(7, 20, 0, PlayerType.BEAR, true);
    }

    @Override
    public int getDefaulthealth() {
        return 0;
    }
}
