import java.util.Random;
import java.util.ArrayList;

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
        _key = key;
    }

    public ArrayList<Character> encrypt(ArrayList<Character> cleartext) {
        ArrayList<Character> ciphertext;
        ArrayList<Character> scrambled;

        for(int i = 0; i < cleartext.size() - 1) {
            sub = rand.nextInt(cleartext.size() - 1);
            if(scrambled.contains(sub))
        }

        return ciphertext;
    }
    
    public ArrayList<Character> decrypt(ArrayList<Character> ciphertext) {
        ArrayList<Character> cleartext;

        return cleartext;
    }
}
