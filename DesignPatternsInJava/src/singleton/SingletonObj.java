package singleton;

public class SingletonObj {
    private static final SingletonObj singletonObj = new SingletonObj();

    private SingletonObj(){}

    public static SingletonObj getInstance() {
        return singletonObj;
    }

    public void showMessage(){
        System.out.println("Hello From Singleton Object!");
    }
}
