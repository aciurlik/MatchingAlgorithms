import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Driver {
	static ArrayList<Male> maleGroup = new ArrayList<Male>();
	static ArrayList<Female> femaleGroup = new ArrayList<Female>();




	public static boolean isDone() {
		for(Male m: maleGroup) {
			if(!m.isMarried) {
				System.out.println(m.name + "  " + m.isMarried);
				return false;
			}
		}
		for(Female f: femaleGroup) {
			if(!f.isMarried) {
				System.out.println(f.name + " " + f.isMarried);
				return false;
			}
		}
		return true;

	}





	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people do you have in each group");
		String name = scanner.nextLine();
		Integer n = Integer.parseInt(name);
		for(int i= 0; i<n; i++) {
			System.out.println("Please give me the name of the next male");
			String maleName = scanner.nextLine();
			Male m = new Male(maleName);
			maleGroup.add(m);
		}
		for(int i= 0; i<n; i++) {
			System.out.println("Please give me the name of the next female");
			String femaleName = scanner.nextLine();
			Female f = new Female(femaleName);
			femaleGroup.add(f);
		}

		//TODO ADD Some better way to ge in preferneces. Read in, or at least a barrier to make sure they are adding in the correct names
		for(Male m : maleGroup) {
			for(int i = 1; i<=n; i ++) {
				System.out.println("Who is the #" + i + " person on " + m.name + "'s list?");
				String chosenFemaleName = scanner.nextLine();
				Female f = new Female(chosenFemaleName);
				m.preferences.add(f);
			}
		}
		for(Female f: femaleGroup) {
			for(int i = 1; i<=n; i ++) {
				System.out.println("Who is the #" + i + " person on " + f.name + "'s list?");
				String chosenMaleName = scanner.nextLine();
				f.preferences.add(new Male(chosenMaleName));
			}
		}
		System.out.println("PREFERENCES");
		for(Male m: maleGroup) {
			System.out.println(m.toString() + ":" + m.prefList());
		}
		for(Female f: femaleGroup) {
			System.out.println(f.toString() + ":" + f.prefList());
		}
		
		
		
		scanner.close();
		
		
		//Start with the actual algorithm
		while(!isDone()) {
			for(Male m: maleGroup) {
				if(!m.isMarried) {
					Female f = m.preferences.get(m.pointInList);//Gets first remaining choice female
					for(Female femaleFromGroup: femaleGroup) { 
						if(femaleFromGroup.name.equals(f.name)) {//Selects correct female from group
							if(femaleFromGroup.isMarried) {
								Male chosenMale = femaleFromGroup.femaleChoice(m); //female returns her more desired mate
								if(chosenMale.name.equals(m.name)) { //if its the one that proposed
									int notChosen =   maleGroup.indexOf(femaleFromGroup.match); //gets match to be kicked out
									maleGroup.get(notChosen).isMarried = false; //makes him unmarried
									m.isMarried = true; 
									femaleFromGroup.match = m;
									m.match = femaleFromGroup;
									m.pointInList ++;
								}
								else {
									m.pointInList ++;
								//	m.isMarried = false; Probably Redundant 
	
								}

							}
							else {
								femaleFromGroup.isMarried = true; // matches Male and Female
								m.isMarried = true; 
								femaleFromGroup.match = m;
								m.match = femaleFromGroup; 
								m.pointInList = m.pointInList + 1; //moves the selection up one
							}
						}
					}
				}
			}
		}
		for(Male m: maleGroup) {
			System.out.println(m.name + ":  " + m.match.name);
		}



	}

}