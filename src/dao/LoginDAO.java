package dao;

import java.sql.SQLException;
import BCrypt.BCrypt;

public class LoginDAO extends DAO {

	public boolean checkCombo(String user, String password) {
		try {
			open();
			resultSet = statement.executeQuery("select Gebruikersnaam,wachtwoord from gebruiker");
			while (resultSet.next()) {
				String user1 = resultSet.getString("Gebruikersnaam");
				String pwhash = resultSet.getString("wachtwoord");
				if(user.equals(user1) && BCrypt.checkpw(password, pwhash)){
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	}

	public void setPassword(String user, String password) {
		try {
			String pwHash =  BCrypt.hashpw(password, BCrypt.gensalt());
			open();
			preparedStatement = connect.prepareStatement("UPDATE gebruiker SET wachtwoord=? WHERE Gebruikersnaam=?;");
			preparedStatement.setString(1, pwHash);
			preparedStatement.setString(2, user);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
