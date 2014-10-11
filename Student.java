package student;

/**
 * Casey Bennington
 * 
 * 1/25/04
 * 
 * Part of Student 3
 */
public class Student
{
	//defines variables
	String firstname, lastname, studentID, gradYear;
	final int MAX_GRADES = 99;
	private int[] grades = new int[MAX_GRADES];
	int numGrades;

	public void gradeInput(int numOfCourseGrades)
	{
		numGrades = numOfCourseGrades;
		grades = new int[numOfCourseGrades];
		for (int Grade = 0; Grade < numGrades; Grade++)
		{
			System.out.print("Enter Grade(" + Grade + "): ");
			int inputGrade = Keyboard.readInt();
			setGrades(Grade, inputGrade);
		}
	}

	//Stores student Information.
	public void studentInfo()
	{
		System.out.print("First name: ");
		firstname = Keyboard.readString();
		System.out.print("Last name: ");
		lastname = Keyboard.readString();
		System.out.print("Student ID: ");
		studentID = Keyboard.readString();
		System.out.print("Graduation Year: ");
		gradYear = Keyboard.readString();

		setFirstname(firstname);
		setLastname(lastname);
		setStudentID(studentID);
		setGradYEar(gradYear);
	}

	public Student(String first, String last, String ID, String grad)
	{
		firstname = first;
		lastname = last;
		studentID = ID;
		gradYear = grad;
	}

	public Student()
	{

	}

	public Student(
		String first,
		String last,
		String ID,
		String grad,
		int grade[],
		int numOfGrades)
	{
		firstname = first;
		lastname = last;
		studentID = ID;
		gradYear = grad;
		int gradeNum = -1;

		do
		{
			grades[gradeNum + 1] = grade[gradeNum + 1];
		}
		while (gradeNum < numOfGrades);
	}
	/**
	 * Returns the firstname.
	 * @return String
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Returns the grades.
	 * @return int[]
	 */
	public int getGrades(int location)
	{
		return grades[location];
	}

	/**
	 * Returns the gradYear.
	 * @return String
	 */
	public String getGradYear()
	{
		return gradYear;
	}

	/**
	 * Returns the lastname.
	 * @return String
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Returns the studentID.
	 * @return String
	 */
	public String getStudentID()
	{
		return studentID;
	}

	/**
	 * Sets the firstname.
	 * @param firstname The firstname to set
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * Sets the grades.
	 * @param grades The grades to set
	 */
	public void setGrades(int location, int grades)
	{
		grades[location] = grade;
	}

	/**
	 * Sets the gradYear.
	 * @param gradYear The gradYear to set
	 */
	public void setGradYear(String gradYear)
	{
		this.gradYear = gradYear;
	}

	/**
	 * Sets the lastname.
	 * @param lastname The lastname to set
	 */
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * Sets the studentID.
	 * @param studentID The studentID to set
	 */
	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}

	public void printStudentGrades()
	{
		String result;
		result = "Grades: ";

		for (int grd = 0; grd < numGrades; grd++)
		{
			result += grades[grd] + "";
		}
	}

	public String toString()
	{
		String result;
		result = firstname + "" + lastname + "\n";
		result += "Student ID: " + studentID + "\n";
		result += "Graduation Year: " + gradYear + "\n";
		result += "Grades: ";
		for (int grd = 0; grd < numGrades; grd++)
			result += grades[grd] + "";

		return result;
	}
}