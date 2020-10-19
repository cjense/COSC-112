// =============================================================================
/**
 * The <code>Crypt</code> class provides the <code>main()</code> method that
 * drives encryption and decryption operations on any available cipher.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edua
 **/
// =============================================================================



// =============================================================================
// IMPORTS

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
// =============================================================================



// =============================================================================
public class Crypt {
// =============================================================================



    // =========================================================================
    /**
     * The entry point for this program.  Perform encryption or decryption (as
     * requested) using the cipher and key specified.  All data is read from
     * <code>stdin</code> and written to <code>stdout</code>.
     *
     * @param args The command-line arguments.
     **/
    public static void main (String[] args) {

	// Check that sufficient arguments have been provided, and then extract
	// and parse them.
	if (args.length != 3) {
	    showUsageAndExit();
	}
	String cipherName = args[0];
	String operation  = args[1];
	long key = -1;
	try {
	    key = Long.parseLong(args[2]);
	} catch (NumberFormatException e) {
	    showUsageAndExit();
	}
	
	// Initialize the desired cipher, read the source, perform encryption or
	// decryption as requested, and write the result.
	Cipher cipher = Cipher.create(cipherName, key);
	ArrayList<Character> source = read();
	ArrayList<Character> result = null;
	if (operation.equals("encrypt")) {
	    result = cipher.encrypt(source);
	} else if (operation.equals("decrypt")) {
	    result = cipher.decrypt(source);
	} else {
	    showUsageAndExit();
	}
	write(result);
	
    } // main ()
    // =========================================================================



    // =========================================================================
    /**
     * Print the usage information for correct invocation, and then exit with an
     * error code.
     **/
    private static void showUsageAndExit () {

	System.err.printf("USAGE: java Crypt <cipher [Caesar|Substitution]>\n" +
			  "                  <operation [encrypt|decrypt]\n"   +
			  "                  <key>\n"                          );
	System.exit(1);

    } // showUsageAndExit ()
    // =========================================================================
    


    // =========================================================================
    /**
     * Read all input available from <code>stdin</code> and return that data as
     * a list.
     *
     * @returns The sequence of characters that were read.
     **/
    private static ArrayList<Character> read () {

	// Prepare to read from stdin.
	InputStream in = System.in;
	ArrayList<Character> l = Cipher.createList();

	// Read one character at a time, appending each to the list.  If the
	// end-of-file code is returned, end the loop.
	int count = 0;
	while (true) {
	    int readValue = 0;
	    try {
		readValue = in.read();
	    } catch (IOException e) {
		System.err.println("ERROR: Failed reading");
		System.exit(1);
	    }
	    if (readValue == -1) {
		break;
	    } else {
		l.add((char)readValue);
		count += 1;
	    }
	}

	return l;

    } // read ()
    // =========================================================================



    // =========================================================================
    /**
     * Write a list to <code>stdout</code>.
     *
     * @param l The list of characters to be written.
     **/
    private static void write (ArrayList<Character> l) {

	// Prepare to write to stdout.
	OutputStream out = System.out;

	// Write one character at a time.
	for (int i = 0; i < l.size(); i += 1) {
	    char c = l.get(i);
	    try {
		out.write(c);
	    } catch (IOException e) {
		System.err.println("ERROR: Failed writing");
		System.exit(1);
	    }
	}

	// Closing the output flushes any buffered data.  If this step fails,
	// some portion of output's end may be lost---that is, it may not come
	// through stdout.
	try {
	    out.close();
	} catch (IOException e) {
	    System.err.println("WARNING: Failed to close output. " +
			       "Data may have been lost.");
	}

    } // write ()
    // =========================================================================



// =============================================================================
} // class Crypt
// =============================================================================
