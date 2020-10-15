import java.util.*;
import java.io.InputStream;
import java.sql.*;


class Employeedata{
	
	String Firstname;
	String Lastname;
	long contactnum;
	String post;
	Employeedata(){
		Firstname = "";
		Lastname = "";
		contactnum = 0;
		post ="";
	}
	Employeedata(String fn ,String ln,long cn ,String po){
	  fn = 	Firstname ;
		ln = Lastname ;
		cn = contactnum ;
		po = post ;
	}
	
	
	
}


class Insert extends Employeedata
{
	Insert(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of Employees you wish to enter");
		int count = sc.nextInt();
		for(int i=0;i<count;i++)
		{
			System.out.println("Enter Firstname ");
			Firstname= sc.next();
			System.out.println("Enter Lastname");
			Lastname = sc.next();
			System.out.println("Enter Contact number");
			contactnum = sc.nextLong();
			System.out.println("Enter Employee Post ");
			post = sc.next();
			
			addMember();
		}
	}
	
	
	boolean addMember() {
		 Connection connection = ConnectionEstab.getConnection();
		 String sql ="INSERT INTO employeedata (Firstname,Lastname,contactnum,post)  VALUES(?,?,?,?)";
		 try {
		        PreparedStatement ps = connection.prepareStatement(sql);
		        ps.setString(1,Firstname);      //newframe.getusername()
		        ps.setString(2,Lastname);      //newframe.getflatnum()
		        ps.setLong(3,contactnum); 
		        ps.setString(4, post);
		        int i = ps.executeUpdate();
		      if(i > 0) {
		    	  System.out.println("Executed Succesfully");
		        return true;		        
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return false;
	}
	
	
	
}


class  delete extends Employeedata {
	String nam;
	delete(){
		Scanner sc = new  Scanner(System.in);
		System.out.println("Enter name of Employee you want to delete");
		 nam = sc.next();
		 deletemember();
		
		
	}
	boolean deletemember() {
		String sql = "DELETE FROM employeedata WHERE Firstname=?";
		Connection connection = ConnectionEstab.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,nam);
		 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
					System.out.println("A user was deleted successfully!");
					return true;
				}
		} catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return false;
	}
	
}


class fetchall extends Employeedata{
	fetchall(){
		empFetch();
	}
	
	public void empFetch() {
		String sql = "SELECT * FROM employeedata";
		Connection connection = ConnectionEstab.getConnection();
		 
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
		 
			int count = 0;
		 
		while (result.next()){
		    String fname = result.getString("Firstname");
		    String lname = result.getString("Lastname");
		    int cont = result.getInt("contactnum");
		    String pos = result.getString("post");
		 
		    String output = "Employee #%d: %s  %s  %s  %s";
		    System.out.println(String.format(output, ++count,fname , lname, cont, pos));
		}
		
		}catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
}


class Updateemp{
	Updateemp(){
		Scanner sc = new Scanner(System.in );
		String  fnn ,lnn ,poo;
		int coco;
		System.out.println("Enter No Of Employees You Want To Update");
		int i = sc.nextInt();
		for(int j = 0 ;j<i;j++) {
			System.out.println("Enter firstname of employee you want to update");
			fnn = sc.next();
			System.out.println("Enter updates...");
			System.out.println("Enter Lastname");
			lnn = sc.next();
			System.out.println("Enter Contact number");
			coco = sc.nextInt();
			System.out.println("Enter Employee Post ");
			poo = sc.next();
			
			update( lnn ,  coco ,  poo , fnn);
		}
		
	}
	
	public void update(String lnn , int coco , String poo ,String fnn) {
		String sql = "UPDATE employeedata SET Lastname=?, contactnum=?, post=? WHERE Firstname=?";
		Connection connection = ConnectionEstab.getConnection();
		 
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, lnn);
			statement.setInt(2, coco);
			statement.setString(3, poo);
			statement.setString(4, fnn);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}

 public class MaintainRec {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f = null,l = null,p = null;
		long con = 0;
		Scanner sc = new Scanner(System.in);
		Employeedata emp = new Employeedata(f,l,con,p)	;
		
		do {
			System.out.println("1.Insert Employees\n2.Delete Employees\n3.View Employees\n4.Update Employee Data");
			int ch = sc.nextInt();
			switch(ch) {
			case 1 : 
				new Insert();
				break;
			case 2 : 
				System.out.println("Enter No of Employees You Want to Delete");
				int i = sc.nextInt();
				for(int j =0;j<i;j++)
				{
					delete de = new delete();
				}
				break;
			
			case 3: 
				System.out.println("processing....");
				new fetchall();
				break;
				
			case 4:
				new Updateemp();
				break;
			default:
				System.out.println("Invalid input...");
			}
			
			
		}while(true);
		
	}

}
