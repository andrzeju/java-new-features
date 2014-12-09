package pl.au.test.java7;

import java.util.HashMap;
import java.util.Map;

public class DiamondOperator {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String, String> stringMap = new HashMap<>(); //Java 7
//		VS
		Map<String, String> oldStringMap = new HashMap<String, String>(); //before Java 7
	}
}
