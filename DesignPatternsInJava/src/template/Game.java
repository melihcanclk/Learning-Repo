package template;

public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //template method
    public final void play() {
        this.initialize();
        this.startPlay();
        this.endPlay();
    }
}
