import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.util.Properties;
import java.sql.Statement;
import java.sql.ResultSet;

public class QuestUtil {
	
	private QuestUtil()
	{
		// made private so there can´t be an object created from outside!
	}

    static 
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
    }
    
    public static Connection getConnection () throws IOException, SQLException 
    {
    	// Take connection data from the properties file
    	FileInputStream fis = new FileInputStream ("C:\\Users\\Nutzer\\Katrin\\Programmieren_ks\\eclipse_everything\\NitinQuest\\App.properties");
    	Properties properties = new Properties();
		properties.load(fis);
    	
    	// Step2. Establish the connection
    	
    	Connection connection = DriverManager.getConnection(properties.getProperty("url"),
    														properties.getProperty("user"), 
    														properties.getProperty("password"));
    	System.out.println("connection object created");
    	return connection;   	
    }
    
    public static void cleanUp (Connection con, Statement statement, ResultSet resultSet) throws SQLException {
    	//Step 6 close the resources
    	
    	if (con!=null) {
    		con.close();
    	}
    	if (statement !=null) {
    		statement.close();
    	}
    	if (resultSet!= null) {
    		resultSet.close();
    	}
    	
    }
    

}
