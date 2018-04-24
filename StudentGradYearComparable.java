import java.util.Comparator;

public class StudentGradYearComparable implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.graduatingYear - o2.graduatingYear;
			
		
	}

}
