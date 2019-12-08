package dad.javaFX.utiles;

public class ZonaMasDatos {

	public class Language {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public Language[] languages;

	public Language[] getLanguages() {
		return languages;
	}

	public void setLanguages(Language[] languages) {
		this.languages = languages;
	}

	public String calling_code;

	public String getCalling_code() {
		return calling_code;
	}

	public void setCalling_code(String calling_code) {
		this.calling_code = calling_code;
	}
}
