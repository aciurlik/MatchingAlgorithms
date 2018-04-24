import java.util.Comparator;

public class StudentIsMajorComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o2.isMajor - o1.isMajor;
	}

}
