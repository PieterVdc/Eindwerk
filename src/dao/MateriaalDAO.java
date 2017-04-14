package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Materiaal;


public class MateriaalDAO extends DAO{
	public ArrayList<Materiaal> getMaterialen() {
		ArrayList<Materiaal> materiaalList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from Materiaal where deleted is not true");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String naam = resultSet.getString("naam");
				String eenheid = resultSet.getString("eenheid");
				float eenheidsprijs = resultSet.getFloat("eenheidsprijs");
				int MateriaalCategorieId = resultSet.getInt("TypeMateriaalID");
				Materiaal materiaal = new Materiaal(id, naam, eenheid,eenheidsprijs, MateriaalCategorieId);
				materiaalList.add(materiaal);
			}
			return materiaalList;
		} catch (Exception e) {
			return materiaalList;
		} finally {
			close();
		}
	}
	public Materiaal getMateriaal(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * FROM materiaal WHERE id=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String naam = resultSet.getString("naam");
			String eenheid = resultSet.getString("eenheid");
			float eenheidsprijs = resultSet.getFloat("eenheidsprijs");
			int TypeMateriaalID = resultSet.getInt("TypeMateriaalID");
			return new Materiaal(id, naam, eenheid,eenheidsprijs, TypeMateriaalID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			close();
		}
	}
	public void delete(int id){
		try {
			open();
			preparedStatement = connect.prepareStatement("UPDATE materiaal SET deleted=true WHERE id=?;");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public void insert(Materiaal materiaal) {
		try {
			open();
			if (materiaal.getId() == -1) {
				preparedStatement = connect.prepareStatement(
						"INSERT INTO `materiaal` (`naam`,`TypeMateriaalID`,`eenheid`,`eenheidsprijs`) VALUES (?,?,?,?);");
				preparedStatement.setString(1, materiaal.getNaam());
				preparedStatement.setInt(2, materiaal.getMateriaalCategorieId());
				preparedStatement.setString(3, materiaal.getEenheid());
				preparedStatement.setFloat(4, materiaal.getEenheidsprijs());
				preparedStatement.executeUpdate();
			} else {
				preparedStatement = connect.prepareStatement(
						"UPDATE `materiaal` SET naam=?,TypeMateriaalID=?,eenheid=?,eenheidsprijs=? WHERE id=?;");
				preparedStatement.setString(1, materiaal.getNaam());
				preparedStatement.setInt(2, materiaal.getMateriaalCategorieId());
				preparedStatement.setString(3, materiaal.getEenheid());
				preparedStatement.setFloat(4, materiaal.getEenheidsprijs());
				preparedStatement.setInt(5, materiaal.getId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
}
