package dad.javaFX.controller;

import java.io.IOException;

import dad.javaFX.main.GeoFXApp;
import dad.javaFX.utiles.ZonaObject;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootController {

	// REFERENCIA A LA APP PRINCIPAL
	private GeoFXApp app;

	// VISTA PRINCIPAL
	private RootView view = new RootView();

	// TAREAS EN SEGUNDO PLANO PARA CONSEGUIR LA IP
	private Task<ZonaObject> cargarTask;
	private Task<String> ipTarea;

	// COMPONENTES DEL TAB
	LocationController locationController;
	ConexionController conexionController;
	SecurityController securityController;

	// MODEL
	private StringProperty ip = new SimpleStringProperty();
	private ObjectProperty<Node> tabLocation = new SimpleObjectProperty<>();
	private ObjectProperty<Node> tabConexion = new SimpleObjectProperty<>();
	private ObjectProperty<Node> tabSecurity = new SimpleObjectProperty<>();

	public RootController(GeoFXApp app) {

		this.app = app;

		cargarIP();

		view.getCheckBt().setOnAction(evt -> cargarIP());

		view.getIpTxt().textProperty().bind(ip);
		view.getTab_location().contentProperty().bind(tabLocation);
		view.getTab_connection().contentProperty().bind(tabConexion);
		view.getTab_security().contentProperty().bind(tabSecurity);

		try {
			locationController = new LocationController();
			conexionController = new ConexionController();
			securityController = new SecurityController();

			tabLocation.set(locationController.getRootView());
			tabConexion.set(conexionController.getConexionView());
			tabSecurity.set(securityController.getSecurityView());

		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("NO SE HAN PODIDO CARGAR LOS DATOS, CONTACTE....CON ALGUIEN");
			alert.showAndWait();
			Platform.exit();
		}
	}

	private void cargarIP() {
		ipTarea = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return app.getUnirestObject().getUsuarioIP();
			}
		};

		// MIENTRAS ESTE CARGANDO LOS DATOS DE NUESTRA IP NO SE PODRA HACER NADA
		view.getCheckBt().disableProperty().bind(ipTarea.runningProperty());

		ipTarea.setOnSucceeded(e -> {
			ip.set((String) e.getSource().getValue());
			enviarLocation();
		});

		ipTarea.setOnFailed(e -> {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("NO SE HAN PODIDO CARGAR LOS DATOS, CONTACTE....CON ALGUIEN");
			alert.showAndWait();
			Platform.exit();
		});

		new Thread(ipTarea).start();
	}

	private void enviarLocation() {

		final String myIP = ip.get();

		if (myIP == null)
			return;

		cargarTask = new Task<ZonaObject>() {

			@Override
			protected ZonaObject call() throws Exception {
				return app.getUnirestObject().getLocalizacion(myIP);
			}

		};

		// MIENTRAS ESTE CARGANDO LOS DATOS DE NUESTRA IP NO SE PODRA HACER NADA
		view.getCheckBt().disableProperty().bind(cargarTask.runningProperty());

		cargarTask.setOnSucceeded(e -> {
			locationController.setDatosZona((ZonaObject) e.getSource().getValue());
		});

		cargarTask.setOnFailed(e -> {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("NO SE HAN PODIDO CARGAR LOS DATOS, CONTACTE....CON ALGUIEN");
			alert.showAndWait();
			Platform.exit();
		});

		new Thread(cargarTask).start();
	}

	public RootView getRootView() {
		return view;
	}
}
