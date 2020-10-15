/*
Name : ANIRUDDHA . M . GHADGE
Roll No : 231017
Gr No : 21810708
S . Y . BTECH
*/
public class Employee
{
	public static void main(String []args)
	{
		System.out.println("Welcome to the employees database (Parameterless)\n");	
		CreateEmp E1 = new CreateEmp();
		E1.mDisplay();
		System.out.println("Welcome to the employees database\n (Parameterised)");	
		CreateEmp E2 = new CreateEmp(3, 20, "Max", 2300.500, 1000.400);
		E2.mDisplay();
		System.out.println("Welcome to the employees database \n");
		CreateEmp E3 = new CreateEmp();
		E3 = E2;
		E3.mDisplay();
		System.out.println("Welcome to the employees database\n (Copy)"); 
		CreateEmp E4 = new CreateEmp(E3);				
		E4.mDisplay();
		System.out.println("Welcome to the employees database\n (This Pointer)");
		CreateEmp E5 = new CreateEmp(3, 20, "Max");
		E5.mDisplay();
	}
}
class CreateEmp
{
	private int mWorkHours, mAge;
	private String mName;
	private double mSalary, mTax;
	public CreateEmp()							// Parameterless Constructor
	{
		mWorkHours = 0;
		mAge = 0;
		mName = " ";
		mSalary = 0;
		mTax = 0;
	}
	public CreateEmp(int mW, int mA, String mN, double mS, double mT)	// Parameterised Constructor
	{
		mWorkHours = mW;
		mAge = mA;
		mName = mN;
		mSalary = mS;
		mTax = mT;
	}
	public CreateEmp(int mWorkHours, int mAge, String mName)		// Using this pointer
	{
		this.mWorkHours = mWorkHours;
		this.mAge = mAge;
		this.mName = mName;
	}
	public CreateEmp(CreateEmp E)						// Copy Constructor
	{
		mWorkHours = E.mWorkHours;
		mAge = E.mAge;
		mName = E.mName;
		mSalary = E.mSalary;
		mTax = E.mTax;
	}
	public void mDisplay()
	{
		System.out.println("Name : "+ mName + "\nAge : "+ mAge +"\nWork Hours : "+ mWorkHours + "\nSalary : " + mSalary + "\nTax : " + mTax + "\n");
	}
}
/*
Answer
Welcome to the employees database (Parameterless)

Name :  
Age : 0
Work Hours : 0
Salary : 0.0
Tax : 0.0

Welcome to the employees database
 (Parameterised)
Name : Max
Age : 20
Work Hours : 3
Salary : 2300.5
Tax : 1000.4

Welcome to the employees database 

Name : Max
Age : 20
Work Hours : 3
Salary : 2300.5
Tax : 1000.4

Welcome to the employees database
 (Copy)
Name : Max
Age : 20
Work Hours : 3
Salary : 2300.5
Tax : 1000.4

Welcome to the employees database
 (This Pointer)
Name : Max
Age : 20
Work Hours : 3
Salary : 0.0
Tax : 0.0

*/
