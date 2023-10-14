package state;

public class Context {
    private State state = null;

    public Context() {}

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}
