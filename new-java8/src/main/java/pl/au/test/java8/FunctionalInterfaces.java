package pl.au.test.java8;

/**
 * @author Andrzej
 * Functional interface example
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {
		Printable newspaper = (int quantity) -> System.out.println("Paper printed " + quantity + " times");
		newspaper.print(100);
	}
}

@FunctionalInterface
interface Printable {
	public abstract void print(int quantity);
}
