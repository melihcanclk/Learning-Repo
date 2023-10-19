package compositeEntity;

public class CompositeEntityPattern {
    public static void main(String[] args) {
        Client client = new Client();

        client.setData("Test", "data", "21312");
        client.printData();

        client.setData("4123", "bdfgetwe");
        client.printData();
    }
}
