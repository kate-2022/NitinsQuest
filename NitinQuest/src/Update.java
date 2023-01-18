import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	public static void update()
	{		
		System.out.println("input is 3 ");
		try {
			con= QuestUtil.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
	}

}
}