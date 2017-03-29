package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Materiaal;
import dto.TaakType;


public class TaakTypeDAO extends DAO{
	public ArrayList<TaakType> getTaakTypes() {
		ArrayList<TaakType> taakTypeList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from TaakType where deleted is not true");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String naam = resultSet.getString("naam");
				TaakType taakType = new TaakType(id, naam);
				taakTypeList.add(taakType);
			}
			return taakTypeList;
		} catch (Exception e) {
			return taakTypeList;
		} finally {
			close();
		}
	}
	public TaakType getTaakType(int id) {
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * FROM taaktype WHERE id=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String naam = resultSet.getString("naam");
			return new TaakType(id, naam);
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
			preparedStatement = connect.prepareStatement("UPDATE taaktype SET deleted=true WHERE id=?;");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public void insert(TaakType taakType) {
		try {
			open();
			if (taakType.getId() == -1) {
				preparedStatement = connect.prepareStatement(
						"INSERT INTO `taaktype` (`naam`) VALUES (?);");
				preparedStatement.setString(1, taakType.getNaam());
				preparedStatement.executeUpdate();
				
				preparedStatement = connect.prepareStatement(
						"SELECT max(id) FROM `taaktype`");
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				int id = resultSet.getInt(1);
				for (Integer i : taakType.getMaterialList()) {
					preparedStatement = connect.prepareStatement(
							"INSERT INTO `taaktypes_materiaaltype` (`TaakTypesId`,`MateriaalTypeid`) VALUES (?,?);");
					preparedStatement.setInt(1, id);
					preparedStatement.setInt(2, i);
					preparedStatement.executeUpdate();
				}
			} else {
				preparedStatement = connect.prepareStatement(
						"UPDATE `taaktype` SET naam=? WHERE id=?;");
				preparedStatement.setString(1, taakType.getNaam());
				preparedStatement.setInt(2, taakType.getId());
				preparedStatement.executeUpdate();
				
				preparedStatement = connect.prepareStatement(
						"DELETE FROM taaktypes_materiaaltype WHERE taakTypesId=?;");
				preparedStatement.setInt(1, taakType.getId());
				preparedStatement.executeUpdate();
				
				for (Integer i : taakType.getMaterialList()) {
					preparedStatement = connect.prepareStatement(
							"INSERT INTO `taaktypes_materiaaltype` (`TaakTypesId`,`MateriaalTypeid`) VALUES (?,?);");
					preparedStatement.setInt(1, taakType.getId());
					preparedStatement.setInt(2, i);
					preparedStatement.executeUpdate();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public ArrayList<Materiaal> getMaterialen(int id) {
		ArrayList<Materiaal> matList = new ArrayList<>();
		try {
			open();
			
			preparedStatement = connect.prepareStatement("SELECT MateriaalTypeId FROM taaktypes_materiaaltype WHERE TaakTypesId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			MateriaalDAO materiaalDAO = new MateriaalDAO();
			while (resultSet.next()) {
				int MateriaalTypeId = resultSet.getInt("MateriaalTypeId");
				Materiaal materiaal = materiaalDAO.getMateriaal(MateriaalTypeId);
				matList.add(materiaal);
			}
			return matList;
		} catch (Exception e) {
			e.printStackTrace();
			return matList;
		} finally {
			close();
		}
	}
	public ArrayList<Integer> getMaterialenIds(int id) {
		ArrayList<Integer> matList = new ArrayList<>();
		try {
			open();
			
			preparedStatement = connect.prepareStatement("SELECT MateriaalTypeId FROM taaktypes_materiaaltype WHERE TaakTypesId=?;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int MateriaalTypeId = resultSet.getInt("MateriaalTypeId");
				matList.add(MateriaalTypeId);
			}
			return matList;
		} catch (Exception e) {
			e.printStackTrace();
			return matList;
		} finally {
			close();
		}
	}
	
}
