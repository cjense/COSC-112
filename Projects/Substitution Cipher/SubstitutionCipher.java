import java.util.Random;
import java.util.ArrayList;

public class SubstitutionCipher extends Cipher {

    public SubstitutionCipher(long key) { // constructor
        super(key);
    }

    public ArrayList<Character> encrypt(ArrayList<Character> cleartext) {
        Random rand = new Random(getKey());

        int i= 0;
        ArrayList<Integer> substitution = new ArrayList<Integer>();
        ArrayList<Character> ciphertext = new ArrayList<Character>();
        while(i < 256) {
            int random = rand.nextInt(256);
            if(substitution.contains((Integer) random) == false) {
                substitution.add(random);
                i++;
            }
        }

        for(int j = 0; j < cleartext.size(); j++) {
            char clearchar = cleartext.get(j);
            char cipherchar = (char) ((int) substitution.get((int) clearchar));
            ciphertext.add(cipherchar);
        }

        return ciphertext;
    }
    
    public ArrayList<Character> decrypt(ArrayList<Character> ciphertext) {
        Random rand = new Random(getKey());
        int i = 0;
        ArrayList<Character> cleartext = new ArrayList<Character>();
        ArrayList<Integer> substitution = new ArrayList<Integer>();

        while(i < 256) {
            int random = rand.nextInt(256);
            if(substitution.contains((Integer) random) == false) {
                substitution.add(random);
                i++;
            }
        }

        for(int k = 0; k < ciphertext.size(); k++) {
            char cipherchar = ciphertext.get(k);
            char clearchar = (char) ((int) substitution.indexOf((int) cipherchar));
            cleartext.add(clearchar);
        }

        return cleartext;
    }
}
