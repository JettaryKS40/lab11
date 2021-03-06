package tasktimer;

import static java.lang.System.out;

import java.util.function.IntConsumer;

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * @author Keetawat Srichompoo - 5810545840
 */

public class TaskTimer
{
    /** 
     * Define a customer Consumer class that computes <b>both</b> the average 
     * and count of values.
     * An IntConsumer is a special Consumer interface the has an 'int' parameter 
     * in accept().
     */
    
    static class IntCounter implements IntConsumer {
        // count the values
        public int count = 0;
        // total of the values
        private long total = 0;
        /** accept consumes an int. In this method, count the value and add it to total. */
        public void accept(int value) { count++; total += value; }
        /** Get the average of all the values consumed. */
        public double average() { 
            return (count>0) ? ((double)total)/count : 0.0;
        }
        public int getCount() { return count; }
    }
    
    /** Run all the tasks. */
    
    public static void execAndPrint( Runnable task ) {
    	StopWatch watch = new StopWatch();
    	out.println( "Starting task: " + task.toString() );
    	watch.start();
    	task.run();
    	watch.stop();
    	out.printf( "Elapsed time is %f sec\n", watch.getElapsed() );
    }
    
    public static void main(String [] args) {
    	execAndPrint( new TaskOne() );
    	execAndPrint( new TaskTwo() );
    	execAndPrint( new TaskThree() );
    	execAndPrint( new TaskFour() );
    	execAndPrint( new TaskFive() );
    	execAndPrint( new TaskSix() );

    }
    
}