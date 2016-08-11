package continuum_automation.cucumber;




import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.runners.model.TestClass;
import org.testng.Reporter;



public class Utilities {
	
	public static String  getMavenProperties(String key){
	
	 Properties mavenProps = new Properties();
	 InputStream inStream = TestClass.class.getResourceAsStream("/maven.properties");
	 try {
		mavenProps.load(inStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	return mavenProps.getProperty(key);
	}
	
	public Connection connectDB(String URL,String dbName,String userName,String passWord) throws SQLException{
		  Connection connect=null;  
		
		 try{	 
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
		  connect = DriverManager.getConnection( "jdbc:jtds:sqlserver://"+URL+"/"+dbName, userName, passWord );
		   
		    
	 	}catch(Exception e){
	 		e.printStackTrace();
	 		
		}
	 
		 return connect;
	}
	
	public ResultSet executeSQLQuery(Connection connect,String query) throws SQLException{
		Statement stmt=null;
		  ResultSet rs=null;
		
		
		 try{	 
		   stmt = connect.createStatement();
		   rs = stmt.executeQuery(query);
		   
		    
	 	}catch(Exception e){
	 		e.printStackTrace();
	 		
		
	}
		 return rs;
	}
	
	public void closeConnections(Connection con,ResultSet rs) throws SQLException{
		 
		 try{	 
			 rs.close();
			 con.close();
		    
	 	}catch(Exception e){
	 		e.printStackTrace();
		}
		
	}
	
}

