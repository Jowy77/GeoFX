package dad.javaFX.main;

import com.mashape.unirest.http.Unirest;

import dad.javaFX.utiles.UnirestObject;
import dad.javaFX.utiles.UnirestObjectMapper;
import dad.javaFX.controller.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeoFXApp extends Application {

	// KEY_IPAPI
	private final static String CODIGO_IPAPI = "d95a3b3cc6a73e042e2e47175acfccde";
	private final static String CODIGO_IPIFY = "at_eaVCxuWC4TB1saSI24n0UYUol1Prj";

	private RootController rootController;
	private UnirestObject uniObject;

	@Override
	public void start(Stage primaryStage) throws Exception {

		uniObject = new UnirestObject();
		Unirest.setObjectMapper(new UnirestObjectMapper());

		rootController = new RootController(this);

		Scene scene = new Scene(rootController.getRootView());

		primaryStage.setTitle("GEO APP JOEL COUTO LUGO");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

	public UnirestObject getUnirestObject() {
		return this.uniObject;
	}

	public static String getCodigoPapi() {
		return CODIGO_IPAPI;
	}

	public static String getCodigoIpify() {
		return CODIGO_IPIFY;
	}

}
