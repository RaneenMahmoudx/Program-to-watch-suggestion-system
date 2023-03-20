
public class TvProgram implements Comparable<TvProgram>{

	private String title;
	private int year;
	private String country;
	private String Language;
	
	static int numoftv=0;


	public TvProgram(String title, int year, String country, String language) {
		super();
		this.title = title;
		this.year = year;
		this.country = country;
		Language = language;
		
		numoftv++;
		
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getYear() {
		return year;
	}




	public void setYear(int year) {
		this.year = year;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getLanguage() {
		return Language;
	}




	public void setLanguage(String language) {
		Language = language;
	}




	@Override
	public String toString() {
		return "TvProgram [title=" + title + ", year=" + year + ", country=" + country + ", Language=" + Language + "]" +"\n";
	}


	@Override
	public int compareTo(TvProgram o) {
		int x = title.compareTo(o.title);

		if (x != 0) {

			return x;
		}

		else

			return year - o.year;
	}





}
