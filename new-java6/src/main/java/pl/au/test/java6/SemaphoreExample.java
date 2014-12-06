package pl.au.test.java6;

import java.util.concurrent.Semaphore;

/**
 * @author Andrzej
 * 
 * Simple example of semaphores working. 
 * There is only one resource (track) and 2 processes in separate threads (trains).
 * There can only be one train on a track at the moment.
 * Increasing number of permits (trains on tracks) will cause trains to crash into each other.
 */
public class SemaphoreExample {

	private static final int TRAINS_ON_ONE_TRACK = 1;
	private static final Semaphore semaphore = new Semaphore(TRAINS_ON_ONE_TRACK);

	public static void main(String[] args) {
		new Thread(new TrainB(semaphore)).start();
		new Thread(new TrainA(semaphore)).start();
	}

}

class TrainA implements Runnable {

	private static Semaphore sm = null;

	public TrainA(Semaphore sm) {
		TrainA.sm = sm;
	}

	public void run() {
		while (true) {
			try {
				sm.acquire();
				System.out.println("Train A STARTED");
				Thread.sleep(500);
				System.out.println("Train A ARRIVED");
				sm.release();
				Thread.sleep(100);
				System.out.println("Train A READY TO START");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TrainB implements Runnable {

	private static Semaphore sm = null;

	public TrainB(Semaphore sm) {
		TrainB.sm = sm;
	}

	public void run() {
		while (true) {
			try {
				sm.acquire();
				System.out.println("Train B STARTED");
				Thread.sleep(2000);
				System.out.println("Train B ARRIVED");
				sm.release();
				Thread.sleep(100);
				System.out.println("Train B READY TO START");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
