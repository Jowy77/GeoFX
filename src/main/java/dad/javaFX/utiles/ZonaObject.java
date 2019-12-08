package dad.javaFX.utiles;

public class ZonaObject {

	private String country_name;
	private String country_code;
	private String city;
	private String region_name;
	private String zip;
	private String type;
	private double latitude;
	private double longitude;
	private ZonaMasDatos location;
	
	public String getType() {
		return type;
	}

	public String getRegion_name() {
		return region_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCity() {
		return city;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public ZonaMasDatos getLocation() {
		return location;
	}

	public void setLocation(ZonaMasDatos location) {
		this.location = location;
	}
	
	
}
