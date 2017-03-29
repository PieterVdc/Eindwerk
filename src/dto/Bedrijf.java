package dto;

public class Bedrijf extends Klant {
	private String btwNr;
	private String bedrijfsnaam;
	private String contactpersoon;
	
	
	public Bedrijf(int id, String tel, String gsm, String email, String btwNr, String bedrijfsnaam,
			String contactpersoon) {
		super(id, tel, gsm, email);
		this.btwNr = btwNr;
		this.bedrijfsnaam = bedrijfsnaam;
		this.contactpersoon = contactpersoon;
	}
	public String getContactpersoon() {
		return contactpersoon;
	}
	public void setContactpersoon(String contactpersoon) {
		this.contactpersoon = contactpersoon;
	}
	public String getBedrijfsnaam() {
		return bedrijfsnaam;
	}
	public void setBedrijfsnaam(String bedrijfsnaam) {
		this.bedrijfsnaam = bedrijfsnaam;
	}
	public String getBtwNr() {
		return btwNr;
	}
	public void setBtwNr(String btwNr) {
		this.btwNr = btwNr;
	}
	
}
