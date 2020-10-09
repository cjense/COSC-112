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
    public int readInt() throws IOException, InvalidIntegerException {
        int data = 0;
        int count = 0;
        int number = 0;
        int digit = 0;

        boolean isNegative = false;
        boolean throwException = false;

        while(data != -1 && data != 32) {
            try{
                data = in.read();
                digit = data - (int) '0';
            }
            catch(IOException e) {
                throw new IOException(e);
            }

            if(count < 1 && data == 45) { // if first digit is a hyphen, mark as negative number
                System.out.println("negative");
                isNegative = true;
            } else if (count < 1 && data != 45) {
                System.out.println("notn negative");
                isNegative = false;
            } else if(count < 1 && data >= 48 && data <= 57) { // if you're reading the first digit and inputStream returns ASCII values 0-9
                number += digit; // add digit to number
                System.out.println("second not negative");
                isNegative = false;
            }

            if(count > 0 && data >= 48 && data <= 57) { // if you're reading the first digit and inputStream returns ASCII values that correspond to ints 0-9
                number = number * 10 + digit; // multiply by 10 to get digit in right place
            } else if(data == 13) {
                try{
                    data = in.read();
                }
                catch(IOException e) {
                    throw new IOException(e);
                }
                break;
            } else if(data == 32 && number > 0) {
                return number;
            } else if(count > 0 && isNegative && data < 48 || data > 57 && data != 13 && data != 10) {
                throwException = true;
                throw new InvalidIntegerException("Symbol '-' followed by non-numerical character '" + (char) data + "' encountered.");
            } else if(data < 48 || data > 57) {
                throwException = true;
                throw new InvalidIntegerException("Non-numerical character '" + (char) data + "' encountered.");
            }
            count++;
        }

        if(isNegative && throwException == false) { // if number has hyphen in front, return as negative number
            return -number;
        } else if(throwException == false) { // else return as positive number
            return number;
        }
        return 0;
    }
}
