package pl.au.test.java8;

import java.util.function.Function;

/**
 * @author Andrzej
 * Basic lambda expressions
 */
public class Lambdas {

	public static void main(String[] args) {
		
		runLambdaExample();
		runFunctionExample();
		
	}

	private static void runLambdaExample() {
		Runnable operation = () -> System.out.println("Operation run!");
		operation.run();
	}

	private static void runFunctionExample() {
		Function<String, String> prettyPrintMe = s -> {return ".._-" + s + "-_..";};
		System.out.println(prettyPrintMe.apply("testString"));
	}
}
