public class Zombie extends Obstacle{
    public Zombie() {
        super(3, 10, 0, PlayerType.ZOMBIE, true);
    }

    @Override
    public int getDefaulthealth() {
        return 10;
    }
}
