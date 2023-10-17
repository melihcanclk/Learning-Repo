package visitor;

public class Computer implements ComputerPart{

    private final ComputerPart[] computerParts;

    public Computer() {
        computerParts = new ComputerPart[] {
          new Mouse(), new Keyboard(), new Monitor()
        };
    }
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for(ComputerPart part : computerParts) {
            part.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
