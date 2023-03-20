
public class Sport extends TvProgram{


	private String Type;


	public Sport(String title, int year, String country, String language,String Type) {
		super(title, year, country, language);
		this.Type = Type;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}

}
