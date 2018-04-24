
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class RankStudents implements Comparator<Student> {

	private List<Comparator<Student>> listComparators;


	@SafeVarargs
	public RankStudents(Comparator<Student>...comparators) {
		this.listComparators = Arrays.asList(comparators);
	}


	@Override
	public int compare(Student student1, Student student2) {
		for(Comparator<Student> comparator: listComparators) {
			int result = comparator.compare(student1, student2);
			if(result != 0) {
				return result;

			}
		}
		return 0;
	} 


	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Student> listStudents = new ArrayList<Student>();
		ArrayList<TechPosition> masterTechList = new ArrayList<TechPosition>();

		Scanner techScanner = new Scanner(new File("C:\\Users\\aciur\\Desktop\\TechPositions.csv"));
		techScanner.useDelimiter(",");
		techScanner.next();
		techScanner.next();
		techScanner.next();
		while(techScanner.hasNext()) {
			String name = techScanner.next().trim();
			int numberOfPositions = Integer.parseInt(techScanner.next().trim());
			TechPosition job = new TechPosition(name, numberOfPositions);
			masterTechList.add(job);
		}

		techScanner.close();

		Scanner scanner = new Scanner(new File("C:\\Users\\aciur\\Desktop\\TheatreDemo - Sheet1.csv"));
		scanner.useDelimiter(",");
		while(scanner.hasNext()) {
			String toAdd = scanner.next().trim();
			while(toAdd.equals("START")){
				String name = scanner.next();
				int isMajor = scanner.nextInt();
				int year = scanner.nextInt();
				int semesterDifficulty = scanner.nextInt();
				int cumalativeKarma = scanner.nextInt();
				int averageKarma = scanner.nextInt();
				int numberOfProductionsWorked = scanner.nextInt();
				String toInt = scanner.next().trim();
				int workability = Integer.parseInt(toInt);
				String toTech = scanner.next().trim();
				ArrayList<TechPosition> prefs = new ArrayList<TechPosition>();
				while(!toTech.startsWith("END")) {
					
					for(TechPosition t: masterTechList) {
						if(t.nameOfPosition.equals(toTech)) {
							prefs.add(t);
						}
					}
					toTech = scanner.next().trim();



				}
				toAdd = scanner.next().trim();
				Student toAddS = new Student(name, isMajor, year, semesterDifficulty, cumalativeKarma, averageKarma, numberOfProductionsWorked, workability, prefs);
				listStudents.add(toAddS);



			}
		}

	

		scanner.close();

		System.out.println("======= SORTING BY MULTIPLE ATTRIBUTES  ========");



		System.out.println("**** Before Sorting:");
		for(Student student: listStudents) {
			System.out.println(student);
		}

		Collections.sort(listStudents, new RankStudents(
				new StudentIsMajorComparator(),
				new StudentGradYearComparable(),
				new StudentLikabilityComparator()			 
				));


		System.out.println("\n *** After Sorting: ");
		System.out.println("NAME  LIKEAB  KARMA   MAJOR     YEAR ");
		for(Student stu: listStudents) {
			System.out.println(stu);
		}


		for(Student stu: listStudents) {
			int positionInPref = 0;

			while(stu.getAssignedTechPosition() == null && positionInPref < stu.preferences.size()) {
				int toChange = masterTechList.lastIndexOf(stu.preferences.get(positionInPref));
				if(masterTechList.get(toChange).numberNeeded >0) {
					stu.setAssignedTechPosition(stu.preferences.get(positionInPref));
					masterTechList.get(toChange).numberNeeded = masterTechList.get(toChange).numberNeeded -1;
				}
				else {
					positionInPref = positionInPref + 1;
				}

			}

		}
		System.out.println("\n");
		System.out.println("JOB ASSIGMENTS");
		for(Student stu: listStudents) {
			String studentLine = stu.getName();
			if(stu.getAssignedTechPosition() == null) {
				studentLine = studentLine + " Student did not include enough preferences to be assigned a job";
			}
			else {
				studentLine = studentLine + "  " + stu.getAssignedTechPosition().nameOfPosition;
			}
			System.out.println(studentLine);
		}
		System.out.println("THESE JOBS STILL NEED VOLENTEERS");
		for(TechPosition position: masterTechList) {
			if(position.numberNeeded != 0) {
				System.out.println(position.nameOfPosition + " needs " + position.numberNeeded + " more volunteers.");
			}
		}


	}
}











