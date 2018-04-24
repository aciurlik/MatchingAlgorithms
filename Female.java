import java.util.ArrayList;

public class Female {
	Male match;
	boolean isMarried;
	String name; 
	ArrayList<Male> preferences;


	public Female(String name) {
		this.preferences = new ArrayList<Male>();
		this.isMarried = false;
		this.name = name;
	}
	
	
	public String toString() {
		return this.name;
	}


	public String prefList() {
		String n = "";
		for(Male m: preferences) {
			n = n + m.name + ",";

		}
		return n;
	}
	public Male femaleChoice(Male m) {
		for(int i = 0; i<this.preferences.size(); i++) {
			if(this.preferences.get(i).name.equals(m.name)) {
				System.out.println("I AM RETURNING" + m.name );
				return m;
			}

			if(this.preferences.get(i).name.equals(this.match.name)) {
				System.out.println("I AM RETURNING" + this.match.name );
				return this.match;
			}


		}
		return null;
	}
}
