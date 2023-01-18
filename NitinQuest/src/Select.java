import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Select {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet resultSet = null;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void select()
	{
		int sid = 0;
	//	String data ="";
		
		System.out.println("input is 2 (Selection)");

		try {
			con= QuestUtil.getConnection();
			
			System.out.println("Please the student id you want to check for:");
			sid = scan.nextInt();
							
			String sqlSelectQuery = "select slName, sfName, sCourse from quest where sid =" + sid; 
			
			if (con!=null)
				pstmt = con.prepareStatement(sqlSelectQuery);
			
			if (pstmt!=null)
				resultSet = pstmt.executeQuery(sqlSelectQuery);
			
			  if (resultSet!=null) {
			System.out.println("ID\tLAST NAME\tFIRST NAME\tENROLLED COURSE");
			while (resultSet.next())
			{   int id = sid;
				String lastName = resultSet.getString("slName");
				String firstName = resultSet.getString("sfName");
				String enrolledCourse = resultSet.getNString("sCourse");
				System.out.println(sid +"\t" + lastName +"\t"+ firstName + "\t"+ enrolledCourse);
			}
//		    if (resultSet!=null) {
//		    	
//		    	if (resultSet.next()) {
//		    	System.out.println("ID\tLAST NAME\tFIRST NAME\tENROLLED COURSE");
//		    	System.out.println(resultSet.getInt(4)+ "\t"+ 
//		    						resultSet.getString(2) + "\t" + 
//		    						resultSet.getString(1) +"\t"
//		    						+ resultSet.getString(3) +"\t" );
//		    	} else {
//		    		System.out.println("Record not available for the giben id::" + sid);
//		    	}
			
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
