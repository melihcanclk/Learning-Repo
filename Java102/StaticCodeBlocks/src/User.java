public class User {
    private String name;
    private static int counter = 0;

    User(String name){
        this.name = name;
        setCounter(counter + 1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    private static void setCounter(int counter) {
        User.counter = counter;
    }

    {
        System.out.println("Static Code Block");
    }
}
