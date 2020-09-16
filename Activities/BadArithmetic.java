<<<<<<< HEAD
public class BadArithmetic {
    
    public static void main(String[] args) {


	int denominator = 10;
	double reciprocal = 1.0 / denominator;
	double product = 0;

	
	// perform multiplication as repeated addition
	
	for (int i = 0; i < denominator; i++) {
	    product += reciprocal; 
	}

	System.out.println(denominator + " * " + reciprocal + " = " + product);

	double power = product;
	int iter = 50;

	// perform repeated multiplication (iter times)

	for (int i = 0; i < iter; i++) {
	    power *= power;
	}

	System.out.println("(" + denominator + " * " + reciprocal + ")^(2^" + iter + ") = " + power);

	System.out.println("\nNote that both values above should be 1.");

    }
}
=======
public class BadArithmetic {
    
    public static void main(String[] args) {


	int denominator = 10;
	double reciprocal = 1.0 / denominator;
	double product = 0;

	
	// perform multiplication as repeated addition
	
	for (int i = 0; i < denominator; i++) {
	    product += reciprocal; 
	}

	System.out.println(denominator + " * " + reciprocal + " = " + product);

	double power = product;
	int iter = 50;

	// perform repeated multiplication (iter times)

	for (int i = 0; i < iter; i++) {
	    power *= power;
	}

	System.out.println("(" + denominator + " * " + reciprocal + ")^(2^" + iter + ") = " + power);

	System.out.println("\nNote that both values above should be 1.");

    }
}
>>>>>>> d64aae04f5f6455e52738f4a7b9be49df14750f0
