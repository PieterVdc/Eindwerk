package dto;

public abstract class Klant {
	private int id;
	private String tel;
	private String gsm;
	private String email;
	
	

	public Klant(int id, String tel, String gsm, String email) {
		super();
		this.id = id;
		this.tel = tel;
		this.gsm = gsm;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
