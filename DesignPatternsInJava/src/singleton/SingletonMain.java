package singleton;

/**
 * We're going to create a SingleObject class. SingleObject class have its constructor as private and have a static instance of itself.
 * SingleObject class provides a static method to get its static instance to outside world. SingletonPatternDemo, our demo
 * class will use SingleObject class to get a SingleObject object.
 * <a href="https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm">Singleton Pattern</a>
 */
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
