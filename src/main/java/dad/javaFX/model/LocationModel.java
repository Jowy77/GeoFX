package dad.javaFX.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LocationModel {
	
	private StringProperty timeZone = new SimpleStringProperty("NULL");
	private StringProperty currency = new SimpleStringProperty("NULL");
	
	private StringProperty lenguaje = new SimpleStringProperty();
	private StringProperty codLenguaje = new SimpleStringProperty();
	
	private DoubleProperty latitud = new SimpleDoubleProperty();
	private DoubleProperty longitud = new SimpleDoubleProperty();
	
	private StringProperty pais = new SimpleStringProperty();
	private StringProperty pais_cod = new SimpleStringProperty();
	
	private StringProperty call = new SimpleStringProperty();
	
	private StringProperty ciudad = new SimpleStringProperty();
	private StringProperty estado = new SimpleStringProperty();
	
	private StringProperty zip = new SimpleStringProperty();
	
	private ObjectProperty<Image> banderaIcon = new SimpleObjectProperty<Image>();
	
	
	public final StringProperty ciudadProperty() {
		return this.ciudad;
	}
	
	public final String getCiudad() {
		return this.ciudadProperty().get();
	}
	
	public final void setCiudad(final String ciudad) {
		this.ciudadProperty().set(ciudad);
	}
	
	public final StringProperty estadoProperty() {
		return this.estado;
	}
	
	public final String getEstado() {
		return this.estadoProperty().get();
	}
	
	public final void setEstado(final String estado) {
		this.estadoProperty().set(estado);
	}
	
	public final StringProperty zipProperty() {
		return this.zip;
	}
	
	public final String getZip() {
		return this.zipProperty().get();
	}
	
	public final void setZip(final String zip) {
		this.zipProperty().set(zip);
	}
	
	public final ObjectProperty<Image> flagIconProperty() {
		return this.banderaIcon;
	}
	
	public final StringProperty paisProperty() {
		return this.pais;
	}
	
	public final String getPais() {
		return this.paisProperty().get();
	}
	
	public final void setPais(final String pais) {
		this.paisProperty().set(pais);
	}
	
	public final StringProperty pais_codProperty() {
		return this.pais_cod;
	}
	
	public final String getPais_cod() {
		return this.pais_codProperty().get();
	}
	
	public final void setPais_cod(final String pais_cod) {
		this.pais_codProperty().set(pais_cod);
	}
	
	
	public final Image getFlagIcon() {
		return this.flagIconProperty().get();
	}
	
	public final void setFlagIcon(final Image flagIcon) {
		this.flagIconProperty().set(flagIcon);
	}
	
	public final StringProperty languageProperty() {
		return this.lenguaje;
	}
	
	public final String getLanguage() {
		return this.languageProperty().get();
	}
	
	public final void setLanguage(final String lenguaje) {
		this.languageProperty().set(lenguaje);
	}
	
	public final StringProperty language_codProperty() {
		return this.codLenguaje;
	}
	
	public final String getLanguage_cod() {
		return this.language_codProperty().get();
	}
	
	public final void setLanguage_cod(final String codLenguaje) {
		this.language_codProperty().set(codLenguaje);
	}

	public final StringProperty callProperty() {
		return this.call;
	}
	

	public final String getCall() {
		return this.callProperty().get();
	}
	

	public final void setCall(final String call) {
		this.callProperty().set(call);
	}

	public final DoubleProperty latitudProperty() {
		return this.latitud;
	}
	

	public final double getLatitud() {
		return this.latitudProperty().get();
	}
	

	public final void setLatitud(final double latitud) {
		this.latitudProperty().set(latitud);
	}
	

	public final DoubleProperty longitudProperty() {
		return this.longitud;
	}
	

	public final double getLongitud() {
		return this.longitudProperty().get();
	}
	

	public final void setLongitud(final double longitud) {
		this.longitudProperty().set(longitud);
	}


	public final StringProperty currencyProperty() {
		return this.currency;
	}
	

	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	

	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}

	public final StringProperty timeZoneProperty() {
		return this.timeZone;
	}
	

	public final String getTimeZone() {
		return this.timeZoneProperty().get();
	}
	

	public final void setTimeZone(final String timeZone) {
		this.timeZoneProperty().set(timeZone);
	}
	
}