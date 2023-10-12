package interpreter;

public class InterpreterPattern {

    // Rule: Robert and John are male
    public static Expression getMaleExpression() {
        Expression john = new TerminalExpression("John");
        Expression robert = new TerminalExpression("Robert");
        Expression male = new TerminalExpression("Male");

        Expression johnMale = new OrExpression(john, male);
        Expression robertMale = new OrExpression(robert, male);

        return new AndExpression(johnMale, robertMale);
    }

    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarried = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John Male"));
        System.out.println("Julie is a married woman? " + isMarried.interpret("Julie Married"));
    }
}
