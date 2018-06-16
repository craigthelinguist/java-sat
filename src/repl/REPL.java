package repl;

import java.util.Scanner;

import imperatives.Imperative;
import semantics.Environment;

public class REPL {
    
    private static final String HELP =
            "Commands:\nlet VARIABLE = VALUE\n"
            + "solve PROPOSITION\n"
            + "print PROPOSITION\n";

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Parser parser = new Parser();
        Environment env = new Environment();
        while (true) {
            try {
                System.out.print(">> ");
                String str = scan.nextLine();
                if (str.equals("help")) {
                    System.out.println(HELP);
                }
                else if (str.equals("quit") || str.equals("exit"))  {
                    break;
                } else {
                    Imperative imp = parser.interpret(str);
                    String output = imp.exec(env);
                    System.out.println(output);
                }
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        scan.close();
    }

}
