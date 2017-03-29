package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MateriaalCategorie;


public class MateriaalCategorieDAO extends DAO{
	public MateriaalCategorie getMateriaalCategorie(int id){
		
		try {
			open();
			preparedStatement = connect.prepareStatement("SELECT * from materiaalcategorie where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			return new MateriaalCategorie(rs.getInt("Id"), rs.getString("naam"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	public ArrayList<MateriaalCategorie> getMateriaalCategorieen() {
		ArrayList<MateriaalCategorie> materiaalCatList = new ArrayList<>();
		try {
			open();
			resultSet = statement.executeQuery("select * from MateriaalCategorie");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String naam = resultSet.getString("naam");
				MateriaalCategorie materiaal = new MateriaalCategorie(id, naam);
				materiaalCatList.add(materiaal);
			}
			return materiaalCatList;
		} catch (Exception e) {
			return materiaalCatList;
		} finally {
			close();
		}
	}
}