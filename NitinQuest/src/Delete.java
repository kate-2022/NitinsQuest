import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	public static void delete()
	{
		System.out.println("input is 4 ");
		try {
			con= QuestUtil.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
	}
}
