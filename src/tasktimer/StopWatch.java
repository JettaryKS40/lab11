package tasktimer;

/** This class show the user how much time it's take to do the specific task
 *  it's also provide with a elapsed time.
 *  
 *  @author Keetawat Srichompoo - 5810545840
 *
 */

public class StopWatch {
	
	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;
	
	final private static double NANO_SEC = 1.0E-9;

	public void start() {
		startTime = System.nanoTime();
		running = true;
	}

	public void stop() {
		stopTime = System.nanoTime();
		running = false;
	}

	public double getElapsed() {
		double elapsedTime = (stopTime - startTime) * NANO_SEC;
		return elapsedTime;
	}

}
