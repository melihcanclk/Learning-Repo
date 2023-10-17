package visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Keyboard computer) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor computer) {
        System.out.println("Displaying Monitor.");
    }

    @Override
    public void visit(Mouse computer) {
        System.out.println("Displaying Mouse.");
    }
}
