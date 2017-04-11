package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DAO {
       
  protected Connection connect = null;
  protected Statement statement = null;
  protected PreparedStatement preparedStatement = null;
  protected ResultSet resultSet = null;

  final private String host = "localhost";
  final private String user = "app";
  final private String passwd = "appp";
 
  protected void open(){
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://" + host + "/db_eindwerk?"
              + "user=" + user + "&password=" + passwd + "&useSSL=false" );
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      
     
    } catch (Exception e) {
    	e.printStackTrace();
    } 
    
  }

  

	protected void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
		}
	}
}


