package dad.javaFX.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ConexionController implements Initializable{
	
	@FXML AnchorPane view;
	
	public ConexionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/conexion.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public AnchorPane getConexionView(){
		return view;
	}

}
