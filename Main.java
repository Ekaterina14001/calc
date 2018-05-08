/*export CLASSPATH=".:/<Javalib>/antlr-4.7.1-complete.jar:%CLASSPATH%"
        alias antlr4='java -jar /<Javalib>/antlr-4.7.1-complete.jar'
        alias grun='java org.antlr.v4.runtime.misc.TestRig'
        antlr4 Calculator.g4*/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
/* SET CLASSPATH=.;C:.Javalib.antlr-4.7.1-complete.jar;%CLASSPATH% */
public class Main
{
    public static void main (String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(System.in);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.input();

        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
