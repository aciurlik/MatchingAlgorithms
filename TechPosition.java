




public class TechPosition {
	String nameOfPosition;
	int numberNeeded;
	
	public TechPosition(String name, int numberOfStudentsNeeded) {
		this.nameOfPosition = name;
		this.numberNeeded = numberOfStudentsNeeded;
	}
	
	
	public boolean equals(TechPosition tOne) {
		if(tOne.nameOfPosition.equals(this.nameOfPosition)) {
			return true;
		}
		else {
			return false;
		}
	}

}
