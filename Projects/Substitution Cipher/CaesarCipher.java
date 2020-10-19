// =============================================================================
/**
 * The <code>CaesarCipher</code> encrypts/decrypts by shifting each cleartext
 * character by a fixed number of positions in the alphabet (given by the key)
 * forward/backward, respectively.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edua
 **/
// =============================================================================


// =============================================================================
// IMPORTS

import java.util.ArrayList;
// =============================================================================



// =============================================================================
public class CaesarCipher extends Cipher {
// =============================================================================



    // =========================================================================
    /**
     * The specialized constructor.
     *
     * @param key The key to used to shift each character for
     * encryption/decryption.
     **/
    public CaesarCipher (long key) {

	super(key);

    } // CaesarCipher ()
    // =========================================================================



    // =========================================================================
    /**
     * Replace each character in the given cleartext by shifting forward, by the
     * number of positions specified by the key, each character.
     *
     * @param cleartext The unencrypted source data.
     * @returns The ciphertext -- the encrypted result.
     **/
    public ArrayList<Character> encrypt (ArrayList<Character> cleartext) {

	ArrayList<Character> ciphertext = Cipher.createList();

	// Shift each character of the cleartext, appending the result to the
	// ciphertext.  Assume an English encoding with 256 possible character
	// values, wrapping around any shifts beyond a value of 255.
	for (int i = 0; i < cleartext.size(); i += 1) {

	    char clearchar  = cleartext.get(i);
	    char cipherchar = (char)((clearchar + getKey()) % 256);
	    ciphertext.add(cipherchar);

	}

	return ciphertext;
	
    } // encrypt ()
    // =========================================================================
    


    // =========================================================================
    /**
     * Replace each character in the given ciphertext by shifting backward, by
     * the number of positions specified by the key, each character.
     *
     * @param ciphertext The encrypted source data.
     * @returns The cleartext -- the decrypted result.
     **/
    public ArrayList<Character> decrypt (ArrayList<Character> ciphertext) {

	ArrayList<Character> cleartext = Cipher.createList();

	// Shift each character of the cleartext, appending the result to the
	// ciphertext.  Assume an English encoding with 256 possible character
	// values, wrapping around any shifts beyond a value of 255.
	for (int i = 0; i < ciphertext.size(); i += 1) {

	    char cipherchar = ciphertext.get(i);
	    char clearchar  = (char)((cipherchar - getKey()) % 256);
	    cleartext.add(clearchar);

	}

	return cleartext;
	
    } // decrypt ()
    // =========================================================================



// =============================================================================    
} // class CaesarCipher
// =============================================================================
