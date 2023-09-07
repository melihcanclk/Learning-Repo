package singleton;

public class SingletonMain {
    public static void main(String[] args) {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingletonObj singletonObj = SingletonObj.getInstance();

        //show the message
        singletonObj.showMessage();
    }
}
