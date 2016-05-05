package tasktimer;

import static java.lang.System.out;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Process all the words in a file using Scanner to read and parse input.
 * Display summary statistics and elapsed time.
 */

class TaskOne implements Runnable {

	private InputStream instream = Dictionary.getWordsAsStream();
	private Scanner in = new Scanner(instream);
	private long totalsize = 0;
	private int count = 0;
	private double averageLength;
	
	@Override
	public void run() {
		
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        
        averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	
	public String toString() {
		String output = "read words using Scanner and a while loop";
		return output;
	}
	
}
