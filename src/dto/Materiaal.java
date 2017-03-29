package dto;

import dao.MateriaalCategorieDAO;

public class Materiaal {
	final private int id;
	private String naam;
	private String eenheid;
	private float eenheidsprijs;
	private int materiaalCategorieId;
	
	public Materiaal(int id,String naam,String eenheid,float eenheidsprijs,int materiaalCategorieId){
		this.id = id;
		this.naam = naam;
		this.eenheid = eenheid;
		this.eenheidsprijs = eenheidsprijs;
		this.materiaalCategorieId = materiaalCategorieId;		
	}

	public int getId() {
		return id;
	}

	public String getEenheid() {
		return eenheid;
	}

	public void setEenheid(String eenheid) {
		this.eenheid = eenheid;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public MateriaalCategorie getMateriaalCategorie() {
		MateriaalCategorieDAO materiaalCategorieDAO = new MateriaalCategorieDAO();
		return materiaalCategorieDAO.getMateriaalCategorie(materiaalCategorieId);
	}
	public int getMateriaalCategorieId() {
		return materiaalCategorieId;
	}

	public void setMateriaalCategorieId(int materiaalCategorieId) {
		this.materiaalCategorieId = materiaalCategorieId;
	}

	public float getEenheidsprijs() {
		return eenheidsprijs;
	}

	public void setEenheidsprijs(float eenheidsprijs) {
		this.eenheidsprijs = eenheidsprijs;
	}
	
}
