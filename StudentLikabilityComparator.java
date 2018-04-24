import java.util.Comparator;

public class StudentLikabilityComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getLikability() - o1.getLikability();
	}
	
	

}
