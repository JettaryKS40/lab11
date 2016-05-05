package tasktimer;
import java.io.*;

/** this provide the class that want to use this inputStream
 * 	this get from the wordList.txt files
 * 
 *  @author Keetawat Srichompoo - 5810545840
 *
 */

public class Dictionary {
	
	private static String DICTIONARY = "wordlist.txt";
	
	public static InputStream getWordsAsStream() {
		InputStream instream = TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
		return instream;
	}
	
}
