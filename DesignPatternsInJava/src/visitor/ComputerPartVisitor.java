package visitor;

public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Keyboard computer);
    void visit(Monitor computer);
    void visit(Mouse computer);

}
