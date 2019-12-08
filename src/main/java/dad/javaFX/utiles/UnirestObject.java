package dad.javaFX.utiles;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dad.javaFX.main.GeoFXApp;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UnirestObject {


	public String getUsuarioIP() {
		
		try {
			
			IpObject ip = Unirest.get("https://geo.ipify.org/api/v1?apiKey="+GeoFXApp.getCodigoIpify()).asObject(IpObject.class).getBody();
			return ip.getIp();
			
		} catch (UnirestException e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("ERROR");
			alerta.setHeaderText("NO SE HAN PODIDO OBTENER LOS DATOS DE LA IP");
		}
		
		return null;
	}
	
	public ZonaObject getLocalizacion(String ip) {
		
		try {
			
			ZonaObject location = Unirest.get(String.format("http://api.ipapi.com/%s?access_key=%s&format=1", ip, GeoFXApp.getCodigoPapi())).asObject(ZonaObject.class).getBody();
			
			if( location == null) {	
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("ERROR");
				alerta.setHeaderText("NO SE HAN PODIDO OBTENER LOS DATOS DE USUARIO");
			}
			
			return location;
			
		} catch( UnirestException e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("ERROR");
			alerta.setHeaderText("NO SE HAN PODIDO OBTENER LOS DATOS DE LOCALIZACION DEL USUARIO");
		}
		
		return null;
	}
}
