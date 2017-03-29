package dto;

public class MateriaalCategorie {
	private int id;
	private String naam;

	
	

	public MateriaalCategorie(int id, String naam) {
		super();
		this.id = id;
		this.setNaam(naam);
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
	
}
