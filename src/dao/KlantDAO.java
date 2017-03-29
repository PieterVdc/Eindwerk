package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Bedrijf;
import dto.Klant;
import dto.Particulier;


public class KlantDAO extends DAO{
	public ArrayList<Bedrijf> getBedrijven() {
		ArrayList<Bedrijf> klantList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from bedrijf");
			while (resultSet.next()) {
				int id = resultSet.getInt("klantId");
				
				preparedStatement = connect.prepareStatement("SELECT * FROM klant WHERE id=?;");
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String tel = rs.getString("tel");
				String gsm = rs.getString("gsm");
				String email = rs.getString("email");
				rs.close();
				String btwNr = resultSet.getString("btwNr");
				String bedrijfsnaam = resultSet.getString("bedrijfsnaam");
				String contactpersoon = resultSet.getString("contactpersoon");
				Bedrijf bedrijf = new Bedrijf(id,tel,gsm,email,btwNr,bedrijfsnaam,contactpersoon);
				klantList.add(bedrijf);
			}
			return klantList;
		} catch (Exception e) {
			e.printStackTrace();
			return klantList;
		} finally {
			close();
		}
	}
	public ArrayList<Particulier> getParticulieren() {
		ArrayList<Particulier> klantList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from particulier");
			while (resultSet.next()) {
				int id = resultSet.getInt("klantId");
				
				preparedStatement = connect.prepareStatement("SELECT * FROM klant WHERE id=?;");
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String tel = rs.getString("tel");
				String gsm = rs.getString("gsm");
				String email = rs.getString("email");
				rs.close();
				String voornaam = resultSet.getString("voornaam");
				String familienaam = resultSet.getString("familienaam");
				Particulier particulier = new Particulier(id,tel,gsm,email,voornaam,familienaam);
				klantList.add(particulier);
			}
			return klantList;
		} catch (Exception e) {
			e.printStackTrace();
			return klantList;
		} finally {
			close();
		}
	}
	
	public Klant getKlant(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT klantId FROM bedrijf WHERE klantId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return getBedrijf(id);
			}else {
				return getParticulier(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			close();
		}
	}
	
	private Bedrijf getBedrijf(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * FROM klant WHERE id=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tel = resultSet.getString("tel");
			String gsm = resultSet.getString("gsm");
			String email = resultSet.getString("email");
			
			
			preparedStatement = connect.prepareStatement("SELECT * FROM bedrijf WHERE klantId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String btwNr = resultSet.getString("btwNr");
			String bedrijfsnaam = resultSet.getString("bedrijfsnaam");
			String contactpersoon = resultSet.getString("contactpersoon");
			Bedrijf bedrijf = new Bedrijf(id,tel,gsm,email,btwNr,bedrijfsnaam,contactpersoon);
			
			return bedrijf;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			close();
		}
	}
	private Particulier getParticulier(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * FROM klant WHERE id=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tel = resultSet.getString("tel");
			String gsm = resultSet.getString("gsm");
			String email = resultSet.getString("email");
			
			
			preparedStatement = connect.prepareStatement("SELECT * FROM particulier WHERE klantId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String voornaam = resultSet.getString("voornaam");
			String familienaam = resultSet.getString("familienaam");
			Particulier particulier = new Particulier(id,tel,gsm,email,voornaam,familienaam);
			
			return particulier;
			
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
