package dto;

import java.util.ArrayList;

import dao.TaakTypeDAO;

public class TaakType {
	private int id;
	private String naam;
	private ArrayList<Integer> materialList;
	

	public TaakType(int id, String naam) {
		super();
		this.id = id;
		this.naam = naam;
		TaakTypeDAO taakTypeDAO = new TaakTypeDAO();
		materialList = taakTypeDAO.getMaterialenIds(id);
	}
	public TaakType(int id, String naam,ArrayList<Integer> materialList) {
		super();
		this.id = id;
		this.naam = naam;
		this.materialList = materialList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getMateriaalString() {
		TaakTypeDAO taakTypeDAO = new TaakTypeDAO();
		ArrayList<Materiaal> matList = taakTypeDAO.getMaterialen(id);
		String matString = "";
		for (Materiaal materiaal : matList) {
			matString+=materiaal.getNaam();
			matString += ",";
		}
		if(!matString.equals("")){
		matString = matString.substring(0, matString.length()-1);
		}
		return matString;
		
	}
	

	public ArrayList<Integer> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(ArrayList<Integer> materialList) {
		this.materialList = materialList;
	}
	
}
