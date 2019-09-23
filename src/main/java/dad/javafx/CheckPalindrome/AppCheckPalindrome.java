package dad.javafx.CheckPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppCheckPalindrome extends Application {

	private Label comprobarLabel;
	private Button comprobarButton;
	private TextField nombreText;

	@Override
	public void start(Stage primaryStage) throws Exception {
		nombreText = new TextField();
		nombreText.setPromptText("Introduce la palabra");
		nombreText.setMaxWidth(150);

		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));

		comprobarLabel = new Label("Aqui saldrá el la respuesta");

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText, comprobarButton, comprobarLabel);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Comprobador de palíndromos");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {
		String palabra = nombreText.getText();
		
		if(checkPalindrome(palabra)==true) {
			comprobarLabel.setText("Es palíndromo");
			comprobarLabel.setStyle("-fx-text-fill: green");
		}
		else {
			comprobarLabel.setText("No es palíndromo");
			comprobarLabel.setStyle("-fx-text-fill: red");
		}
	}

	boolean checkPalindrome(String inputString) {
		int longitud = inputString.length();
		String reverso = "";
		boolean condicion;
		int i;

		for (i = longitud - 1; i >= 0; i--) {
			reverso = reverso + inputString.charAt(i);
		}
		if (reverso.equals(inputString))
			condicion = true;

		else
			condicion = false;

		return condicion;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
