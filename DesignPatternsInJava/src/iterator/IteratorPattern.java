package iterator;

public class IteratorPattern {
    public static void main(String[] args) {
        Container nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }

    }
}
