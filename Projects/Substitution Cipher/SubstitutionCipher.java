import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class SubstitutionCipher extends Cipher {
    private long _key;
    int sub;
    Random rand = new Random();

    String abc = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<Character> alphabetray;
    for(int i = 0; i < abc.length(); i++) {
        alphabetray.add(abc.charAt(i));
    }

    public SubstitutionCipher(long key) {
        super();
    }

    public ArrayList<Character> encrypt(ArrayList<Character> cleartext) {
        ArrayList<Character> ciphertext;

        ArrayList<Character> scrambled;
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
        ArrayList<Character> cleartext;

        return cleartext;
    }
}
