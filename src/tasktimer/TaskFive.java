package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 * Append all the words from the dictionary to a String.
 * This shows why you should be careful about using "string1"+"string2".
 */

public class TaskFive implements Runnable {

	private InputStream instream = Dictionary.getWordsAsStream();
	private int count = 0;
	private BufferedReader br = null;
	
    static final int MAXCOUNT = 50_000;
	
	@Override
	public void run() {
		
        try {
            br = new BufferedReader( new InputStreamReader(instream) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }

        String result = "";
        String word = null;
        
        try {
            while( (word=br.readLine()) != null && count < MAXCOUNT) {
                result = result + word;
                count++;
            }
        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
        System.out.printf("Done appending %d words to string.\n", count);
        
	}
	
	public String toString() {
		String output = "append "+MAXCOUNT+" words to a String using +";
		return output;
		
	}

}
