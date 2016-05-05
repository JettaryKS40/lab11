package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 * Append all the words from the dictionary to a StringBuilder.
 * Compare how long this takes to appending to String.
 */

public class TaskSix implements Runnable {

	private InputStream instream = Dictionary.getWordsAsStream();
	private int count = 0;
	private BufferedReader br = null;

	static final int MAXCOUNT = 50_000;

	@Override
	public void run() {

		try {
			br = new BufferedReader( new InputStreamReader(instream) );
		} catch (Exception ex) {
			out.println("Could not open dictionary: "+ex.getMessage() );
			return;
		}

		StringBuilder result = new StringBuilder();
		String word = null;

		try {
			while( (word=br.readLine()) != null  && count < MAXCOUNT) {
				result.append(word);
				count++;
			}
		} catch(IOException ioe) { System.out.println( ioe.getMessage() ); }

	}

	public String toString() {
		String output = "append "+MAXCOUNT+" words to a StringBuilder";
		return output;

	}

}
