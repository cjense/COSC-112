////////////////////////////////////////////////////////////
// 
// Parser.java
//
// Name: Claire Jensen
//
// Description:
//
// Grade: 
//
// Grader Comments:
//
////////////////////////////////////////////////////////////

import java.io.InputStream;
import java.io.IOException;

public class Parser {

    private InputStream in;

    public static final int CHAR_ZERO = (int) '0';

    public Parser (InputStream in) {
	this.in = in;
    }

    // Complete the following method as described in the assignment
    public int readInt () {
        int data = in.read();
        int count = 0;
        int number = 0;
        int digit = data - (int) '0';

        boolean isNegative = false;

        while(data != -1 || in.read() == 32) {
            if(count == 1 && in.read() == 45) { // if first digit is a hyphen, mark as negative number
                isNegative = true;
            }
            if(count == 1) { // if you're reading the first digit
                if(in.read() >= 48 && in.read() <= 57) { // if inputStream returns ASCII values 0-9
                    number += digit;
                }
            } else if(count > 1) { 
                if(in.read() >= 48 && in.read() <= 57) {
                    number = number * 10 + digit;
                }
            }
            count++;

            if(isNegative) {
                return -number;
            } else {
                return number;
            }

        }
        return number;
    }
}
