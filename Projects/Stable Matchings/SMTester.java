import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SMTester {
       
    public static void main (String[] args) {

	SMInstance ex1 = new SMInstance("example-1-instance.txt");
	Matching matching1 = new Matching(ex1, "example-1-matching-1.txt");
	Matching matching2 = new Matching(ex1, "example-1-matching-2.txt");

	System.out.println("Current SMInstance:\n" + ex1);
	System.out.println("Testing the stability of the following matching:\n" + matching1);
	ex1.setMatching(matching1);
	if (ex1.isStable()) {
	    System.out.println("The matching is stable!");
	}
	else {
	    System.out.println("The matching is not stable: " + ex1.getBlockingPair() + " is a blocking pair!\n");
	}

	System.out.println("Testing the stability of the following matching:\n" + matching2);
	ex1.setMatching(matching2);
	if (ex1.isStable()) {
	    System.out.println("The matching is stable!");
	}
	else {
	    System.out.println("The matching is not stable: " + ex1.getBlockingPair() + " is a blocking pair!\n");
	}

	SMInstance ex2 = new SMInstance("example-2-instance.txt");
	System.out.println("Current SMInstance:\n" + ex2);
	System.out.println("Computing stable matching...");
	ex2.computeStableMatching();
	System.out.println(ex2.getMatching());

	SMInstance ex3 = new SMInstance("example-3-instance.txt");
	System.out.println("Current SMInstance:\n" + ex3);
	System.out.println("Computing stable matching...");
	ex3.computeStableMatching();
	System.out.println(ex3.getMatching());
    }

}
