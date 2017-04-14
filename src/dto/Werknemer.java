package dto;

import java.sql.Date;

public class Werknemer {
	private int id;
	private String voornaam;
	private String familienaam;
	private Date aanwervingsdatum;
	
	public Werknemer(int id, String voornaam, String familienaam, Date aanwervingsdatum) {
		super();
		this.id = id;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.aanwervingsdatum = aanwervingsdatum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	public Date getAanwervingsdatum() {
		return aanwervingsdatum;
	}
	public void setAanwervingsdatum(Date aanwervingsdatum) {
		this.aanwervingsdatum = aanwervingsdatum;
	}
	
	
	
}
