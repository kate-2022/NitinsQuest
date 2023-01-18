
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NQuestmain {
	
	static {
		
		System.out.println("What type of operation do you want to perform?");
		System.out.println("1. Press 1 for Insert operation");
		System.out.println("2. Press 2 for Select operation");
		System.out.println("3. Press 3 for Update operation");
		System.out.println("4. Press 1 for Delete operation");
		System.out.println("5. Press 5 for exit");
	
	}


	public static void main(String[] args) {
		
//		Connection con = null;
//		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		if (input >0) {
		
			if (input==1)
				Insert.insert();      
			else if (input==2)
				Select.select();
			else if (input==3)
				Update.update();
			else if (input==4)
				Delete.delete();
			else if (input==5)
				System.out.println("Request closed.");
			else 
				{
				System.out.println("Invalid operation! Please type in a number between 1 and 5!");
				}
		}
		else 
		{
			System.out.println("Invalid operation!");
		}
	
	}
}
