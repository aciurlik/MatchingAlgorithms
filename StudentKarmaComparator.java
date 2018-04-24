import java.util.Comparator;

public class StudentKarmaComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getKarmaScore() - o1.getKarmaScore();
	}
	
	
	

}
