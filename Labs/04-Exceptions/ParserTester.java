import java.io.InputStream;
import java.io.IOException;

public class ParserTester {

    public static void main (String[] args) {

        Parser p = new Parser(System.in);
        int    x = 0;

	// Modify the loop below so that the code also catches
	// InvalidIntegerExceptions and prints the appropriate error
	// message.
	
	while (true) {
	    try {
		System.out.print("Enter a number (-1 to exit): ");
		x = p.readInt();
		System.out.println("x = " + x);
		
		if (x == -1) {
		    System.out.println("Goodbye!");
		    return;
		}		
	    }
	    catch (IOException e) {
		System.out.println("Reading error: " + e);
		return;
	    }	    

	}
        
    }
}
