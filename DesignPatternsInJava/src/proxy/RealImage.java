package proxy;

public class RealImage implements Image{
    private final String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }


    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading image from " + fileName + "...");
    }
}
