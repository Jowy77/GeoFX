package dad.javaFX.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javaFX.model.LocationModel;
import dad.javaFX.utiles.ZonaObject;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

public class LocationController implements Initializable {

	@FXML
	private AnchorPane view;

	@FXML
	private ImageView flagImg;

	@FXML
	private Label latitudLbl, longitudLbl, locationLbl, conLocationLbl, zipLbl, langLbl, timeLbl, callLbl, currencyLbl;

	// MODEL
	private LocationModel model = new LocationModel();

	public LocationController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/location.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Bindings.bindBidirectional(latitudLbl.textProperty(), model.latitudProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(longitudLbl.textProperty(), model.longitudProperty(), new NumberStringConverter());

		locationLbl.textProperty().bind(Bindings.concat(model.paisProperty(), " (", model.pais_codProperty(), ")"));
		conLocationLbl.textProperty().bind(Bindings.concat(model.ciudadProperty(), " (", model.estadoProperty(), ")"));

		zipLbl.textProperty().bind(model.zipProperty());
		callLbl.textProperty().bind(Bindings.concat("+", model.callProperty()));

		flagImg.imageProperty().bind(model.flagIconProperty());

		// ESTOS DATOS LOS DEJO EN NULL PORQUE LA VERSION GRATUITA DE LA APP NO LOS
		// PROPORCIONA
		currencyLbl.textProperty().bind(model.currencyProperty());
		timeLbl.textProperty().bind(model.timeZoneProperty());

	}

	public void setDatosZona(ZonaObject info) {
		
		model.setCiudad(info.getCity());
		model.setEstado(info.getRegion_name());

		model.setCall(info.getLocation().getCalling_code());

		model.setZip(info.getZip());
		model.setLatitud(info.getLatitude());
		model.setLongitud(info.getLongitude());

		model.setPais(info.getCountry_name());
		model.setPais_cod(info.getCountry_code());

		model.setFlagIcon(
				new Image(getClass().getResource("/imagenes/banderas/" + info.getCountry_code() + ".png").toString()));

	}

	public AnchorPane getRootView() {
		return view;
	}
}
