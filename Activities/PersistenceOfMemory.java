public class PersistenceOfMemory {
    public static void setIntValue (int a, int value) {
	a = value;
    }

    public static void setNumberValue (Number a, int value) {
	a.value = value;
    }
    
    public static void main (String[] args) {
	// dealing with ints

	System.out.println("Setting initial values of a and b...");
	    
	int a = 10;
	int b = 5;

	System.out.println("a = " + a + ", b = " + b + "\n");

	System.out.println("Setting b = a");
	b = a;
	System.out.println("a = " + a + ", b = " + b + "\n");

	
	System.out.println("Setting a = 20");
	a = 20;
	System.out.println("a = " + a + ", b = " + b + "\n");

	System.out.println("Executing setIntValue(a, 0)...");
	setIntValue(a, 0);
	System.out.println("a = " + a + ", b = " + b + "\n");

	System.out.println("Initializing Numbers");
	Number aNumber = new Number();
	Number bNumber = new Number();
	aNumber.value = 10;
	bNumber.value = 5;
	System.out.println("aNumber = " + aNumber.value + ", bNumber = " + bNumber.value + "\n");
		
	System.out.println("Setting bNumber = aNumber");
	bNumber = aNumber;
	System.out.println("aNumber = " + aNumber.value + ", bNumber = " + bNumber.value + "\n");

	System.out.println("Setting aNumber to 20");
	aNumber.value = 20;
	System.out.println("aNumber = " + aNumber.value + ", bNumber = " + bNumber.value + "\n");

	System.out.println("Executing setNumberValue(aNumber, 0)");
	setNumberValue(aNumber, 0);
	System.out.println("aNumber = " + aNumber.value + ", bNumber = " + bNumber.value + "\n");


    }
}
