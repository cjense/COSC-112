public class PairTester {
    public static void main (String[] args) {

	System.out.println("Creating a pair of Numbers...");
	PairOfNumbers pair = new PairOfNumbers(1, 2);
	System.out.println("pair = " + pair.getString());

	System.out.println("Creating a Number num from pair.getFirst()");
	Number num = pair.getFirst();

	System.out.println("Setting num.value to 3");
	num.value = 3;

	System.out.println("Now pair = " + pair.getString());
    }
}
