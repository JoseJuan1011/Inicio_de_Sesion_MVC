package dad.javafx.InicioSesionMVC.View;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class IniciarSesionView extends GridPane {
	
	//componentes HBox_1
	private Label Usuario_Label;
	private TextField Usuario_TextField;
	
	//componentes HBox_2
	private Label Contraseña_Label;
	private PasswordField Contraseña_PasswordField;
	
	//Componentes HBox_3
	private Button Acceder_Button;
	private Button Cancelar_Button;
	
	private HBox Buttons_HBox;
	
	public IniciarSesionView() {
		super();
		
		Usuario_Label= new Label("Usuario: ");
		
		Usuario_TextField= new TextField();
		Usuario_TextField.setPromptText("Usuario");
		
		Contraseña_Label= new Label("Contraseña: ");
		
		Contraseña_PasswordField= new PasswordField();
		Contraseña_PasswordField.setPromptText("Contraseña");
		
		Acceder_Button= new Button();
		Acceder_Button.setText("Acceder");
		
		Cancelar_Button= new Button();
		Cancelar_Button.setText("Cancelar");
		
		Buttons_HBox= new HBox(Acceder_Button, Cancelar_Button);
		Buttons_HBox.setSpacing(10);
		Buttons_HBox.setAlignment(Pos.CENTER);
		
		setAlignment(Pos.CENTER);
		setHgap(5);
		setVgap(5);
		addRow(0, Usuario_Label, Usuario_TextField);
		addRow(1, Contraseña_Label, Contraseña_PasswordField);
		addRow(2, Buttons_HBox);
		
		GridPane.setColumnSpan(Buttons_HBox, 3);
		
		GridPane.setFillWidth(Usuario_Label, true);
		GridPane.setFillWidth(Contraseña_Label, true);
		
		ColumnConstraints[] cols= {
				new ColumnConstraints(),
				new ColumnConstraints()
		};
		
		getColumnConstraints().setAll(cols);
		
		RowConstraints [] rows = {
				new RowConstraints(),
				new RowConstraints()
		};
	}

	public TextField getUsuario_TextField() {
		return Usuario_TextField;
	}

	public PasswordField getContraseña_PasswordField() {
		return Contraseña_PasswordField;
	}

	public Button getAcceder_Button() {
		return Acceder_Button;
	}

	public Button getCancelar_Button() {
		return Cancelar_Button;
	}
}
