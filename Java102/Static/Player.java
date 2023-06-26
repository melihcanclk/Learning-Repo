public class Player {
    String name;
    int id;

    public static int count = 0;

    public Player(String name, int id){
        this.name = name;
        this.id = id;
        count++;
    }
}
