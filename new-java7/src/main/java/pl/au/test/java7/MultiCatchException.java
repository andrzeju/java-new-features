package pl.au.test.java7;

import java.util.Random;

public class MultiCatchException {

	public static void main(String[] args) throws Exception {
		try {
			boolean randomBoolean = new Random().nextBoolean();
			
			if (randomBoolean) {
				throw new ExceptionOne();
			} else {
				throw new ExceptionTwo();
			}
			
		} catch (ExceptionOne | ExceptionTwo e) {
			System.out.println("Caught Exception " + e);
		}
		
	}
}

class ExceptionOne extends Exception {
	private static final long serialVersionUID = -5161775643283835682L;
}

class ExceptionTwo extends Exception {
	private static final long serialVersionUID = 5954814484408786712L;
}