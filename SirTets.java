import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mathew Boyes, Kimberley Smith, Ash Cochran
 */ 

public class SirTets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  

        Scanner scanner = new Scanner(System.in); 
        while (scanner.hasNextLine()) {
            String ln = scanner.nextLine();
            String[] input = ln.split(" ");

            if (!ln.isEmpty() && ln.charAt(0) != '#') {
                System.out.println(ln);

                if (input.length == 2) {  
                  int first = Integer.parseInt(input[0]);
                  int second = Integer.parseInt(input[1]);
                  Grid g = new Grid(first, second);
                  g.getGrid();
        
    
                } else {
                    System.out.println("# Syntax error" + "\n");
                }
            }

        }
        scanner.close();
        
    }
 
}
