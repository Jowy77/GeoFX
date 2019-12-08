package dad.javaFX.utiles;

import com.google.gson.Gson;

public class UnirestObjectMapper implements com.mashape.unirest.http.ObjectMapper {

	private Gson gson = new Gson();
	
	@Override
	public <T> T readValue(String s, Class<T> aClass) {
		try{
			return gson.fromJson(s, aClass);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public String writeValue(Object o) {
		try{
			return gson.toJson(o);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}