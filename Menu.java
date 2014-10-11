package student;

/**
 * Casey Bennington
 * 
 * 1/25/04
 * 
 * make a menu
 */
public class Menu
{
	Course[] course = new Course[3];
	Student[] student = new Student[99];
	Course currentCourse;
	Student currentStudent;
	int usedStudentIndex;
	public int numCourse = 0;

	public Menu()
	{

	}
	//*****************************************
	//Displays the Course Menu, gets user input, and calls desired method.
	//*****************************************
	public void CourseMenu()
	{
		System.out.print(
			"\n"
				+ "1.-Add or Create a course"
				+ "\n"
				+ "2.-Change course's period"
				+ "\n"
				+ "3.-Change course's description"
				+ "\n"
				+ "4.-Find a course"
				+ "\n"
				+ "5.-Display course students"
				+ "\n"
				+ "6.-Display course roll"
				+ "\n"
				+ "7.-Go to student menu"
				+ "\n"
				+ "99.Quit"
				+ "\n"
				+ "\n"
				+ "Menu Option#: ");
		int input = Keyboard.readInt();
		if (input == 1)
		{
			createCourse();
		}
		if (input == 2)
		{
			changeCoursePeriod();
		}
		if (input == 3)
		{
			changeCourseDescription();
		}
		if (input == 4)
		{
			findCourse();
		}
		if (input == 5)
		{
			displayCourseStudents();
		}
		if (input == 6)
		{
			displayCourseRoll();
		}
		if (currentCourse == null)
		{
			System.out.println("Find Course (option 4) First!");
			findCourse();
		}
		if (input == 7)
		{
			StudentMenu();
		}
	}

	//******************************************
	//Displays the Student Menu, gets user input, and calls desired method.
	//******************************************
	public void StudentMenu()
	{
		System.out.print(
			"\n"
				+ "1.-Add or Create a student"
				+ "\n"
				+ "2.-Add or Change student's grades"
				+ "\n"
				+ "3.-Change student's ID"
				+ "\n"
				+ "4.-Change Student's graduation year"
				+ "\n"
				+ "5.-Display student's info"
				+ "\n"
				+ "6.-Display student's grades"
				+ "\n"
				+ "7.-Find a student"
				+ "\n"
				+ "8.-Course Menu"
				+ "\n"
				+ "\n"
				+ "Menu Option#: ");
		int input = Keyboard.readInt();
		if (input == 1)
		{
			createStudent();
		}
		if (input == 2)
		{
			addStudentGrades();
		}
		if (input == 3)
		{
			changeStudentID();
		}
		if (input == 4)
		{
			changeGradYear();
		}
		if (input == 5)
		{
			displayStudentInfo();
		}
		if (input == 6)
		{
			displayStudentGrades();
		}
		if (input == 7)
		{
			findStudent();
		}
		if (input == 7)
		{
			CourseMenu();
		}
	}
	//************************************************
	//Creates a new course and asks to add students
	//************************************************
	public void createCourse()
	{
		course[numCourse] = new Course();
		course[numCourse].courseInfo();

		System.out.print("Add any student? (1-Yes, 2-No):");
		int option = Keyboard.readInt();
		if (option == 1)
		{
			course[numCourse].studentInput();
		}
		numCourse++;
		menuRestart();
	}
	//***********************************************
	//Changes the current course's period (find course first)
	//***********************************************
	public void changeCoursePeriod()
	{
		if (currentCourse == null)
		{
			System.out.println("Find the course(menu opt. 4) first.");
			findCourse();
		}
		else
		{
			currentCourse.coursePeriod();
		}
		menuRestart();
	}
	//***********************************************
	//Changes the course's description (find course first)
	//***********************************************
	public void changeCourseDescription()
	{
		if (currentCourse == null)
		{
			System.out.println("Find the course(menu opt. 4) first.");
			findCourse();
		}
		else
		{
			currentCourse.courseDescription();
		}
		menuRestart();
	}
	//**********************************************
	//Finds a course and makes it the current couse in order to use
	//various methods.
	//**********************************************
	public void findCourse()
	{
		currentCourse = new Course();

		System.out.print("Name of course to search for: ");
		String name = Keyboard.readString();

		int courseIndex = 0;

		do
		{
			String verify = course[courseIndex].getName();

			if (verify.compareTo(name) == 0)
			{
				currentCourse = course[courseIndex];
				courseIndex = 99;
			}

			courseIndex++;

		}
		while (courseIndex < 3);
		menuRestart();
	}
	//********************************************
	//
	//********************************************
	public void findCourseStudent()
	{
		currentCourse = new Course();

		System.out.print("Name of course to search for: ");
		String name = Keyboard.radString();

		int courseIndex = 0;

		do
		{
			String verify = course[courseIndex].getName();

			if (verify.compareTo(name) == 0)
			{
				currentCourse = course[courseIndex];
				courseIndex = 99;
			}
			courseIndex++;
		}
		while (courseIndex < 3);
	}
	//**********************************************
	//
	//**********************************************
	public void displayCourseStudents()
	{
		if (currentCourse == null)
		{
			System.out.println("Find the course (menu opt. 4) first");
			findCourse();
		}
		else
		{
			currentCourse.getStudentNames();
		}
		menuRestart();
	}

	//***********************************************
	//
	//***********************************************
	public void displayCourseRoll()
	{
		if (currentCourse == null)
		{
			System.out.println("Find the course (menu opt. 4) first");
			findCourse();
		}
		else
		{
			currentCourse.printlnCourseRoll();
		}
		menuRestart();
	}
	//***********************************************
	//
	//***********************************************
	public void createStudent()
	{
		Student[] student = new Student[99];
		usedStudentIndex = 0;
		student[usedStudentIndex].studentInfo();
		usedStudentIndex++;
		menuRestart();
	}

	//***********************************************
	//
	//***********************************************
	public void addStudentGrades()
	{
		if (currentStudent == null)
		{
			System.out.println("Find the student (menu opt. 7) first");
			findStudent();
		}
		else
		{
			currentStudent.gradeInput(currentCourse.getNumOfGrades());
		}
		menuRestart();
	}
	//***********************************************
	//
	//***********************************************
	public void changeStudentID()
	{
		if (currentStudent == null)
		{
			System.out.println("Find the student (menu opt. 7) first");
			findStudent();
		}
		else
		{
			System.out.print("Enter StudentID: ");
			String studID = KeyboardString();

			currentStudent.setStudentID(studID);
		}
		menuStudentAgain();
	}
	//***********************************************
	//
	//***********************************************
	public void changeGradYear()
	{
		if (currentStudent == null)
		{
			System.out.println("Find the student (menu opt. 7) first");
			findStudent();
		}
		else
		{
			System.out.println("Enter Grad Year: ");
			String gradYear = Keyboard.readString();

			currentStudent.setGradYear(gradYear);
		}
		menuStudentAgain();
	}
	//***********************************************
	//
	//***********************************************

	public void displayStudentInfo()
	{
		System.out.println(currentStudent);

		menuStudentAgain();
	}
	//**************************************************
	//
	//**************************************************
	public void displayStudentGrades()
	{
		int max = currentCourse.getNumOfGrades();

		for (int grade = 0; grade < max; grade++)
		{
			System.out.print(currentStudent.getGrades(grade));
		}
		menuStudentAgain();
	}
	//**************************************************
	//
	//**************************************************
	public void findStudent()
	{
		currentStudent - new Student();
		System.out.print("Is the student in a course? (1-Yes, 2-No); ");
		int inCourse = Keyboard.readInt();

		if (inCourse == 1)
		{
			findCourseStudent();
			System.out.print("Enter student's first name: ");
			String name = Keyboard.readString();
			currentStudent = currentCourse.findSingleStudent(name);
		}
		if (inCourse == 2)
		{
			System.out.println("Enter student's first name: ");
			String name = Keyboard.readString();
			int studentIndex = 0;
			do
			{
				String verify = student[studentIndex].getFirstname();

				if (verify.compareTo(name) == 0)
				{
					currentStudent = student[studentIndex];
					studentIndex = 999;
				}
				studentIndex++;
			}
			while (studentIndex < 99);
		}
		menuStudentAgain();
	}
	//***************************************************
	//
	//***************************************************
	public void menuRestart()
	{
		System.out.print("Do anything else? (1-Yes, 2-No): ");
		int input = Keyboard.readInt();
		if (input == 1)
		{
			CourseMenu();
		}
	}
	//**************************************************
	//
	//**************************************************
	public void menuStudentAgain()
	{
		System.out.print(
			"Do anything else? (1-Go back to the Course Menu,"
				+ "\n"
				+ "2-Go back to the Student Menu, 3-No): ");
		int input = Keyboard.readInt();
		if (input == 1)
		{
			CourseMenu();
		}
		if (input == 2)
		{
			StudentMenu();
		}
	}
}
