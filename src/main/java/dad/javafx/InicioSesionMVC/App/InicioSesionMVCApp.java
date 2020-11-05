package dad.javafx.InicioSesionMVC.App;

import dad.javafx.InicioSesionMVC.View.IniciarSesionView;
import dad.javafx.InicioSesionMVC.controller.IniciarSesionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesionMVCApp extends Application {
	
	// controllers
	
	private IniciarSesionController Controller;
	
	//model
 	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Controller = new IniciarSesionController();
		
		
		
		Scene scene = new Scene(Controller.getView(), 300, 200);

		primaryStage.setTitle("Iniciar Sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
}
