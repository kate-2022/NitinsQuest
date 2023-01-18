import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet res = null;
	
    static Scanner scan = new Scanner(System.in);
    
	
	
	public static void insert () 
	{ 	String sfName = null;
	   	String slName = null;
	   	int sid = 0;
		String sCourse = null;
		
		System.out.println("input is 1 (Insertion) "); 
		try {
			con= QuestUtil.getConnection();
			
			String sqlInsertQuery = "insert into quest (`sfName`, `slName`, `sid`, `sCourse`) "
					+ "values (?,?,?,?) ";
			
			if (con != null)
				pstmt = con.prepareStatement(sqlInsertQuery);
			
			if (pstmt!= null) {
				
				// use precompiled query to set the values
				System.out.println("Please enter first name of student: ");
				sfName = scan.next();
				pstmt.setString(1, sfName);
				
				System.out.println("Please enter last name of student: ");
				slName = scan.next();
				pstmt.setString(2, slName);
				
				System.out.println("Please enter student id: ");
				sid = scan.nextInt();
				pstmt.setInt(3, sid);
				
				System.out.println("Please enter course name of student: ");
				sCourse = scan.next();
				pstmt.setString(4, sCourse);
				
				
				System.out.println(sqlInsertQuery);
				
				// execute the query
				
				int rowCount = pstmt.executeUpdate();
				System.out.println("No of rows affected: " + rowCount);
				
				System.out.println("Record inserted successfully!");
				
			}
	
		} catch (IOException ie) {
			System.out.println("Record insertion failed!");
			ie.printStackTrace();
		} catch (SQLException se) {
			System.out.println("Record insertion failed!");
			se.printStackTrace();
		} catch (Exception e) {	
			System.out.println("Record insertion failed!");
			e.printStackTrace();
		}finally {
			try {
				QuestUtil.cleanUp(con, pstmt, null);
				}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
         
		
	
		
	}

}
