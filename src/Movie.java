
public class Movie extends TvProgram{

	private String Type;


	public Movie(String title, int year, String country, String language,String Type) {
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
