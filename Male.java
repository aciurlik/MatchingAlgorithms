import java.util.ArrayList;

public class Male {
	Female match;
	boolean isMarried;
	String name;
	int pointInList;
	ArrayList<Female> preferences;
	
	public Male(String name) {
		this.preferences = new ArrayList<Female>();
		this.isMarried = false;
		this.pointInList = 0;
		this.name = name;
	}
	
	
	public String toString() {
		return this.name;
	}

	
	public String prefList() {
		String n = "";
		for(Female f: preferences) {
			n = n + f.name + ",";

			
		}
		return n; 
	}
}
