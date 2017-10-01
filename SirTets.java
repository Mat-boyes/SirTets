
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class SirTets {

    /**
     * @param args the command line arguments
     * test
     */
    public static void main(String[] args) {
  

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String ln = scanner.nextLine();
            String[] input = ln.split(" ");

            if (!ln.isEmpty() && ln.charAt(0) != '#') {
                System.out.println(ln);

                if (input.length == 2) {
                    //do Sir Tets
                    System.out.println("you printed two numbers");
    
                } else {
                    System.out.println("# Syntax error" + "\n");
                }
            }

        }
    }
 
}
