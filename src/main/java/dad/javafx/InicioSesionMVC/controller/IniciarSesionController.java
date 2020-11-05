package dad.javafx.InicioSesionMVC.controller;

import dad.javafx.InicioSesionMVC.utils.Search_CSV;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import dad.javafx.InicioSesionMVC.View.IniciarSesionView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IniciarSesionController {
	
	//view
	
	private IniciarSesionView view = new IniciarSesionView();
	
	//model
	
	private StringProperty Usuario = new SimpleStringProperty();
	private StringProperty Contraseña = new SimpleStringProperty();
	
	private BooleanProperty Estado = new SimpleBooleanProperty();
	
	private static String Contraseña_Cifrada;
	
	private Alert Estado_Alert;
	
	public IniciarSesionController() {
		
		Usuario.bind(view.getUsuario_TextField().textProperty());
		Contraseña.bind(view.getContraseña_PasswordField().textProperty());
		
		view.getAcceder_Button().setOnAction(e -> onCodificarAction(e));
		view.getCancelar_Button().setOnAction(e -> onCancelarAction(e));		
	}
	
	private void onCodificarAction(ActionEvent e) {
		Contraseña_Cifrada = DigestUtils.md5Hex(Contraseña.get()).toUpperCase();
		try {
			Estado.set(Search_CSV.Buscar(Usuario.get(), Contraseña_Cifrada));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Hubo problemas durante la busqueda de los usuarios");
		}
		AlertEstado();
	}
	
	private void onCancelarAction(ActionEvent e) {
		System.exit(0);
	}
	public void AlertEstado() {
		if (Estado.get()) {
			Estado_Alert= new Alert(AlertType.CONFIRMATION);
			Estado_Alert.setTitle("Acceso Permitido");
			Estado_Alert.setHeaderText("Las Credenciales de Acceso son válidas");
			Estado_Alert.showAndWait();
			System.exit(0);
		}
		else {
			Estado_Alert= new Alert(AlertType.ERROR);
			Estado_Alert.setTitle("Acceso denegado");
			Estado_Alert.setHeaderText("El usuario y/o la contraseña no son válidos");
			Estado_Alert.showAndWait();
			System.exit(0);
		}
	}
	
	/*
	private static void MostrarContraseña () {
		System.out.println(Contraseña_Cifrada);
	}
	
	public static void main(String args[]) {
		MostrarBotones();
	}
	*/
	public IniciarSesionView getView() {
		return view;
	}
	
	public Alert getEstado_Alert() {
		return Estado_Alert;
	}
}
