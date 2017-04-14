package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Werknemer;


public class WerknemerDAO extends DAO{
	public ArrayList<Werknemer> getWerknemers() {
		ArrayList<Werknemer> klantList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from Werknemer");
			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				
				preparedStatement = connect.prepareStatement("SELECT * FROM persoon WHERE id=?;");
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String voornaam = rs.getString("Voornaam");
				String familienaam = rs.getString("naam");
				rs.close();
				Date aanwervingsdatum = resultSet.getDate("aanwervingsdatum");
				Werknemer werknemer = new Werknemer(id,voornaam,familienaam,aanwervingsdatum);
				klantList.add(werknemer);
			}
			return klantList;
		} catch (Exception e) {
			e.printStackTrace();
			return klantList;
		} finally {
			close();
		}
	}
	

	
	public Werknemer getWerknemer(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * FROM persoon WHERE id=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tel = resultSet.getString("tel");
			String gsm = resultSet.getString("gsm");
			
			
			preparedStatement = connect.prepareStatement("SELECT * FROM Werknemer WHERE klantId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String voornaam = resultSet.getString("voornaam");
			String familienaam = resultSet.getString("familienaam");
			Date aanwervingsdatum = resultSet.getDate("aanwervingsdatum");
			Werknemer werknemer = new Werknemer(id,voornaam,familienaam,aanwervingsdatum);
			
			return werknemer;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			close();
		}
	}
	
	
//	public void delete(int id){
//		try {
//			open();
//			preparedStatement = connect.prepareStatement("UPDATE materiaaltype SET deleted=true WHERE id=?;");
//			preparedStatement.setInt(1, id);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//	}
//	public void insert(Materiaal materiaal) {
//		try {
//			open();
//			if (materiaal.getId() == -1) {
//				preparedStatement = connect.prepareStatement(
//						"INSERT INTO `materiaaltype` (`naam`,`MateriaalCategorieId`,`eenheid`,`eenheidsprijs`) VALUES (?,?,?,?);");
//				preparedStatement.setString(1, materiaal.getNaam());
//				preparedStatement.setInt(2, materiaal.getMateriaalCategorieId());
//				preparedStatement.setString(3, materiaal.getEenheid());
//				preparedStatement.setFloat(4, materiaal.getEenheidsprijs());
//				preparedStatement.executeUpdate();
//			} else {
//				preparedStatement = connect.prepareStatement(
//						"UPDATE `materiaaltype` SET naam=?,MateriaalCategorieId=?,eenheid=?,eenheidsprijs=? WHERE id=?;");
//				preparedStatement.setString(1, materiaal.getNaam());
//				preparedStatement.setInt(2, materiaal.getMateriaalCategorieId());
//				preparedStatement.setString(3, materiaal.getEenheid());
//				preparedStatement.setFloat(4, materiaal.getEenheidsprijs());
//				preparedStatement.setInt(5, materiaal.getId());
//				preparedStatement.executeUpdate();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
//	}
}
