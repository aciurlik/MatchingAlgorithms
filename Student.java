import java.util.ArrayList;

public class Student {
	//lower ranked ahead
	int SemesterDifficulty;
	int graduatingYear;
	//Higher are ranked ahead
	int workability;
	int cumalativeKarma;
	int averageKarma;
	int isMajor;
	int semesterDifficulty;
	TechPosition assignedTechPosition = null;
	ArrayList<TechPosition> preferences;
	String name;
	
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int isMajor, int year, int semesterDifficulty, int cumalativeKarma,
			int averageKarma, int numberOfProductionsWorked, int workability, ArrayList<TechPosition> prefs) {
		this.preferences = prefs;
		this.name = name;
		this.workability = workability;
		this.cumalativeKarma = cumalativeKarma;
		this.averageKarma = averageKarma;
		//0 not, 1 undeclared, 2 yes
		this.isMajor = isMajor;
		this.SemesterDifficulty = semesterDifficulty;
		this.graduatingYear = year;
		
	}
	

	
	public Student(String name, int isMajor, int year, int semesterDifficulty, int cumalativeKarma,
			int averageKarma, int numberOfProductionsWorked, int workability) {
		this.name = name;
		this.workability = workability;
		this.cumalativeKarma = cumalativeKarma;
		this.averageKarma = averageKarma;
		//0 not, 1 undeclared, 2 yes
		this.isMajor = isMajor;
		this.SemesterDifficulty = semesterDifficulty;
		this.graduatingYear = year;
		
	}
	
	
	
	public int getSemesterDifficulty() {
		return SemesterDifficulty;
	}


	public void setSemesterDifficulty(int semesterDifficulty) {
		SemesterDifficulty = semesterDifficulty;
	}


	public int getLikability() {
		return workability;
	}


	public void setLikability(int likability) {
		workability= likability;
	}


	public int getKarmaScore() {
		return cumalativeKarma;
	}


	public void setKarmaScore(int karmaScore) {
		averageKarma = karmaScore;
	}


	public int isMajor() {
		return isMajor;
	}


	public void setMajor(int major) {
		this.isMajor = major;
	}


	public int getGraduatingYear() {
		return graduatingYear;
	}


	public void setGraduatingYear(int graduatingYear) {
		this.graduatingYear = graduatingYear;
	}


	public ArrayList<TechPosition> getPreferences() {
		return preferences;
	}


	public void setPreferences(ArrayList<TechPosition> preferences) {
		this.preferences = preferences;
	}


	public String getName() {
		return name;
	}

	
	public int getIsMajor() {
		return isMajor;
	}
	public void setIsMajor(int isMajor) {
		this.isMajor = isMajor;
	}
	public TechPosition getAssignedTechPosition() {
		return assignedTechPosition;
	}
	public void setAssignedTechPosition(TechPosition assignedTechPosition) {
		this.assignedTechPosition = assignedTechPosition;
	}

	
	

	public void setName(String name) {
		this.name = name;
	}

	 public  String toString() {
		return String.format("%s\t%d\t%d\t%d\t%d\t", name, workability, averageKarma, isMajor, graduatingYear );
	}
}
