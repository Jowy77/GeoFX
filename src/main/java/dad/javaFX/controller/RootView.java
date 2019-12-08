package dad.javaFX.controller;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RootView extends BorderPane {

	// ELEMENTOS DEL ROOT VIEW
	private ImageView conImg;
	private TextField ipTexto;
	private Button checkButton;
	private HBox ipBox;
	private TabPane tabPanel;
	private Tab tabLocation;
	private Tab tabConexion;
	private Tab tabSeguridad;

	public RootView() {

		conImg = new ImageView(getClass().getResource("/imagenes/conIcon.png").toString());
		conImg.setFitWidth(24.f);
		conImg.setFitHeight(24.f);

		ipTexto = new TextField();
		ipTexto.setEditable(true);

		checkButton = new Button("CHECK IP");
		checkButton.setDefaultButton(true);

		ipBox = new HBox(10, conImg, ipTexto, checkButton);
		ipBox.setFillHeight(true);
		ipBox.setAlignment(Pos.CENTER);

		tabPanel = new TabPane();
		tabPanel.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPanel.setSide(Side.BOTTOM);

		tabLocation = new Tab("Localizacion");
		tabConexion = new Tab("Conexion");
		tabSeguridad = new Tab("Seguridad");

		tabPanel.getTabs().addAll(tabLocation, tabConexion, tabSeguridad);
		tabPanel.setMaxWidth(Double.MAX_VALUE);
		tabPanel.setMaxHeight(Double.MAX_VALUE);

		setTop(ipBox);
		setBottom(tabPanel);
		setAlignment(tabPanel, Pos.CENTER);
	}

	public HBox getIpBox() {
		return ipBox;
	}

	public TabPane getTabPanel() {
		return tabPanel;
	}

	public Tab getTab_location() {
		return tabLocation;
	}

	public Tab getTab_connection() {
		return tabConexion;
	}

	public Tab getTab_security() {
		return tabSeguridad;
	}

	public ImageView getConImg() {
		return conImg;
	}

	public TextField getIpTxt() {
		return ipTexto;
	}

	public Button getCheckBt() {
		return checkButton;
	}
}
