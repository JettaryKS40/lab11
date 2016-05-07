package student;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * Display reminders of students having a birthday soon.
 * @author Keetawat	Srichompoo
 */

public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Comparator<Student> byBirthday, Consumer<Student> action ) {
		students.stream().filter( filter ).sorted( byBirthday ).forEach( action );
	}
	
	public static void main(String[] args) {
		
		//pack all the students in to the List
		List<Student> students = Registrar.getInstance().getStudents();
		
		//Declare a predicate to check if it has the same month or not
		Predicate<Student> studentMonth = (subject) -> subject.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue() ;
		
		//Consumer return this String if call
		Consumer<Student> consumer = (subject) -> System.out.println( subject.toString() + " will have birthday on " + subject.getBirthdate().getDayOfMonth() + " " + subject.getBirthdate().getMonth().toString() ) ;
		
		//Comparator to check and sort the student a and b
		Comparator<Student> byName = (a, b) -> a.toString().compareTo( b.toString() );
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getDayOfYear() - b.getBirthdate().getDayOfYear() ;
		
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, studentMonth, byBirthday, consumer);
	}
}
