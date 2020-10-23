import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class SubstitutionCipher extends Cipher {
    int sub;
    Random rand = new Random();
    ArrayList<Character> alphabetray = new ArrayList<Character>();
    ArrayList<Character> ciphertext = new ArrayList<Character>();
    ArrayList<Character> scrambled = new ArrayList<Character>();

    public SubstitutionCipher(long key) { // constructor
        super(key);
    }

    public ArrayList<Character> scrambleAlphabet() {

        String abc = new String("abcdefghijklmnopqrstuvwxyz");
    
        for(int i = 0; i < abc.length(); i++) {
            alphabetray.add(abc.charAt(i));
        }
        return alphabetray;
    }

    public ArrayList<Character> encrypt(ArrayList<Character> cleartext) {
        
        for(int i = 0; i < (alphabetray.size() - 1); i++) {
            sub = rand.nextInt((alphabetray.size() - 1) -1);
            if (!(scrambled.contains(alphabetray.get(sub)))) {
                scrambled.set(i, alphabetray.get(sub));
            } else { i--; } 
        }

        for(int i = 0; i < (scrambled.size() - 1); i++) {
            if(cleartext.contains(scrambled.get(i))) {
                Collections.replaceAll(scrambled, ciphertext.get(scrambled.get(i)), scrambled.get(i));
            }
        }

        System.out.println(ciphertext);

        return ciphertext;
    }
    
    public ArrayList<Character> decrypt(ArrayList<Character> ciphertext) {
        ArrayList<Character> cleartext = new ArrayList<Character>();

        for(int i = 0; i < (scrambled.size() - 1); i++) {
            if(ciphertext.contains(scrambled.get(i))) {
                Collections.replaceAll(ciphertext, scrambled.get(i), alphabetray.get(scrambled.get(i)));
            }
        }

        return cleartext;
    }
}
