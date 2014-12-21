package pl.au.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Andrzej
 * Basic streams operations
 */
public class Streams {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Bob", "Jane", "George", "Vytautas", "Janine");
		
		Predicate<String> startingWithJ = (String s) -> s.startsWith("J");
		
		System.out.print("Starting with 'J' names: ");
		names.stream().filter(name -> name.startsWith("J")).map(name -> name.concat(",")).forEach(System.out::print);
		System.out.println();
		
		long count = names.stream().filter(startingWithJ).count();
		System.out.println("Starting with 'J' count : " + count);
		
		List<String> upperCaseNames = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		System.out.println("Uppercase names: " + upperCaseNames);
		
		String longestName = names.stream().reduce("", (n1,n2) -> (n1.length() > n2.length() ? n1 : n2));
		System.out.println("Longest name: " + longestName);
		
		System.out.println("Starting with 'J' separated: " + names.stream().filter(startingWithJ).reduce((n1, n2) -> n1 + ", " + n2).get());

	}

}
