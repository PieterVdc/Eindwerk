package dto;

public class Particulier extends Klant{
	private String voornaam;
	private String familienaam;
	public Particulier(int id, String tel, String gsm, String email, String voornaam, String familienaam) {
		super(id, tel, gsm, email);
		this.setVoornaam(voornaam);
		this.setFamilienaam(familienaam);
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
}
