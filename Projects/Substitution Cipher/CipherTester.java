import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CipherTester {
    static final int NUM_TESTS = 100;
    static final int CONSISTENCY_LENGTH = 100;
    static final int NUM_SAMPLES = 100_000;
    
    static Random r = new Random();

    // tests if list is a permutation, i.e., that it contains every character
    // exactly once
    static boolean isPermutation (ArrayList<Character> list) {
	if (list.size() != 256)
	    return false;
	
	for (int i = 0; i < 256; i++) {
	    if (!list.contains((char) i)) {
		return false;
	    }
	}
	
	return true;
    }

    // tests if substitution table is a permutation
    static boolean permutationTest() {
	
	// make an Arraylist containing every char once
	ArrayList<Character> all = new ArrayList<Character>(256);
	
	for (int i = 0; i < 256; i++) {
	    all.add((char) i);
	}

	Cipher cipher = null;
	ArrayList<Character> result = null;
	for (int i = 0; i < 10; i++) {
	    
	    cipher = Cipher.create("Substitution", r.nextLong());
	    result = cipher.encrypt(all);
	    
	    if (!isPermutation(result)) {
		System.out.println("With random seed " + i + " the substitution table is not a permutation.");
		return false;
	    }
	}

	return true;	
    }

    // tests if list contains only copies of a single character
    public static boolean isConstant (ArrayList<Character> list) {
	if (list.size() == 0)
	    return true;
	
	char first = list.get(0);

	for (char ch : list) {
	    if (first != ch) {
		System.out.println("A single character was enciphered as both " + (int) first + " and " + (int) ch);
		return false;
	    }
	}

	return true;
    }

    // tests if substitution cipher performs consistent substitution, i.e., for a
    // single random seed, and cleartext character, the cleartext character is always encrypted
    // as the same ciphertext character
    public static boolean consistencyTest () {
	ArrayList<Character> cleartext = new ArrayList<Character>(CONSISTENCY_LENGTH);
	ArrayList<Character> ciphertext = null;


	for (int k = 0; k < NUM_TESTS; k++) {

	    for (int i = 0; i < 256; i++) {
		cleartext.clear();
	    
		for (int j = 0; j < CONSISTENCY_LENGTH; j++) {
		    cleartext.add((char) i);
		}

		Cipher cipher = Cipher.create("Substitution", r.nextLong());
		ciphertext = cipher.encrypt(cleartext);

		if (!isConstant(ciphertext)) {
		    return false;
		}
	    }
	}
	return true;
    }

    // tests if an array of samples is approximately uniform, i.e.,
    // that the frequencies differ from their expected values by a
    // multiplicative factor of at most threshold
    public static boolean isUniform (int[] counts, int numSamples, double threshold) {
	int lowerThreshold = (int) ((numSamples / counts.length) * threshold);
	int upperThreshold = (int) ((numSamples / counts.length) / threshold);

	for (int i = 0; i < counts.length; i++) {
	    if (counts[i] < lowerThreshold || counts[i] > upperThreshold)
		return false;
	}

	return true;
    }

    // tests if successive encryptions of a single character with
    // different keys is approximately uniform (i.e., all ciphertext
    // characters are roughly equally likely)
    public static boolean uniformityTest () {
	int[] counts = new int[256];

	ArrayList<Character> ciphertext = null;

	for (int i = 0; i < 10; i++) {

	    int ch = r.nextInt(256);

	    ArrayList<Character> cleartext = new ArrayList<Character>(1);
	    cleartext.add((char) ch);

	    for (int j = 0; j < 256; j++)
		counts[j] = 0;

	    System.out.println("Testing character " + ch);

	    for (int j = 0; j < NUM_SAMPLES; j++) {
		Cipher cipher = Cipher.create("Substitution", r.nextLong());
		ciphertext = cipher.encrypt(cleartext);
		counts[(int) ciphertext.get(0)]++;
	    }

	    if (!isUniform(counts, NUM_SAMPLES, 1.0 / 2)) {
		System.out.println("Character frequency counts:\n" + Arrays.toString(counts)
				   + "\n All entries should be approximately equal, but they are not!");
		return false;
	    }
	    
	}

	return true;
    }
    
    public static void main(String[] args) {

	System.out.println("Testing that the substitution cipher's substitution table is a permutation (every character appears exactly once).");
	if (permutationTest()) {
	    System.out.println("Permutation test passed!");
	} else {
	    System.out.println("Permutation test failed!");
	}

	System.out.println("\nTesting that the substitution cipher encrypts the same character consistently");
	if (consistencyTest()) {
	    System.out.println("Consistency test passed!");
	} else {
	    System.out.println("Consistency test failed!");
	}

	System.out.println("\nTesting that the substitution cipher encrypts characters uniformly");
	if (uniformityTest()) {
	    System.out.println("Uniformity test passed!");
	} else {
	    System.out.println("Uniformity test failed!");
	}	
    }
}
