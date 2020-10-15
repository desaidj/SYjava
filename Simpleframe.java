package tourism;
import java.sql.*;
import java.util.Scanner;
public class tourism{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/tourism","root","Prasad@6066");
if(con!=null)
System.out.println("Database connected.");
int ch = 0 ;
int op =1;
Scanner sc = new Scanner(System.in);
do {
System.out.println("1.Add info\n2.Display Database\n3.Exit");
ch=sc.nextInt();
switch(ch) {
case 1 :
do {
System.out.print("Enter Name : ");
String name = sc.next();
System.out.print("Enter Age : ");
int age = sc.nextInt();
System.out.print("Enter Gender : ");
String gender=sc.next();
System.out.print("Enter Interest : ");
String interest=sc.next();
String sql = "INSERT INTO table1 (name ,
age ,gender , interest) VALUES (?, ?, ?, ?)";
PreparedStatement statement =
con.prepareStatement(sql);
statement.setString( 1, name);
statement.setInt( 2, age);
statement.setString( 3, gender);
statement.setString( 4, interest);
int rowsInserted =
statement.executeUpdate();
if (rowsInserted > 0)
System.out.println("New
inserted successfully
Info
!! ");
System.out.println("Add more
");
op = sc.nextInt();
}while(op==1);
break;
case 2:
Info?(1/0)//database
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from
table1");
System.out.println("\t\tName\t\tAge\t\tGender\t\tInterest");
while(rs.next())
System.out.println(rs.getString(1)+" \t\t
"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t "+rs.getString(4));
break;
}
}while(ch!=3);
con.close();
sc.close();
}
catch(Exception e){ System.out.println(e);}
}
}
