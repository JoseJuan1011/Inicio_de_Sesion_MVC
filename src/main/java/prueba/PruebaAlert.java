package prueba;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PruebaAlert extends Application{

	private Alert alerta = new Alert(AlertType.CONFIRMATION);
	private boolean aux_b;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		aux_b = alerta.isShowing();
		Button aux= new Button("Alert");
		aux.setOnAction(e -> {
			try {
				onActionAlert(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Scene verScene = new Scene(aux, 320, 200);
		primaryStage.setTitle("Ver");
		primaryStage.setScene(verScene);
		primaryStage.show();
	}
	
	public void onActionAlert (ActionEvent e) throws Exception {
		/*alerta.setTitle("Prueba");
		alerta.showAndWait();
		System.out.println(aux_b);*/
		System.exit(0);
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
