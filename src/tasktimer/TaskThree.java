package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tasktimer.TaskTimer.IntCounter;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the lines() method which creates a Stream of Strings (one item per line).  
 * Then use the stream to compute summary statistics.
 * In a lambda you cannot access a local variable unless it is final,
 * so (as a cludge) we use an attribute for the count.
 * When this method is rewritten as a Runnable, it can be a non-static attribute
 * of the runnable.
 * Display summary statistics and elapsed time.
 */

class TaskThree implements Runnable {

	private InputStream instream = Dictionary.getWordsAsStream();
	private BufferedReader br = null;
	IntCounter counter = new IntCounter();

	@Override
	public void run() {

		try {
			br = new BufferedReader( new InputStreamReader(instream) );
		}  catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage());
			return;

		}
		
		br.lines().mapToInt( word -> word.length() ).forEach( counter );

		try {
			br.close();

		} catch(IOException ex) { /* ignore it */ }

		out.printf("Average length of %,d words is %.2f\n", counter.getCount(), counter.average() );
		
	}

	public String toString() {
		String output = "read words using BufferedReader and Stream";
		return output;
	}

}
