package vue;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import methodes.Textes;

public class VueDeuxText extends Application {
	TextArea fieldL, fieldR;
	Button lToR;
	Button rToL;

	public void start(Stage stage) {
		fieldL = new TextArea("");
		
		fieldR = new TextArea("");
		fieldR.setEditable(false);
		lToR = new Button("Distribution");

		HBox root = new HBox();
		root.setPadding(new Insets(3, 3, 3, 3));
		root.setAlignment(Pos.CENTER);

		Label lLabel = new Label("Liste personnes");
		VBox lBox = new VBox(lLabel, fieldL);
		
		Label rLabel = new Label("Liste distribution");
		VBox rBox = new VBox(rLabel, fieldR);
		
		
		root.getChildren().addAll(lBox,  lToR, rBox);

		fieldL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		fieldR.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lToR.setMaxSize(lToR.getMaxWidth(), Double.MAX_VALUE);
		lToR.setMinSize(80, 50);
		HBox.setHgrow(lToR, Priority.ALWAYS);
		HBox.setHgrow(rBox, Priority.ALWAYS);
		HBox.setHgrow(lBox, Priority.ALWAYS);
		VBox.setVgrow(fieldL, Priority.ALWAYS);
		VBox.setVgrow(fieldR, Priority.ALWAYS);
		lToR.setAlignment(Pos.CENTER);
		HBox.setMargin(lToR, new Insets(20, 5, 20, 5));
		HBox.setMargin(fieldL, new Insets(2, 2, 2, 2));
		HBox.setMargin(fieldR, new Insets(2, 2, 2, 2));
		lToR.setOnMouseClicked(new Distribution());

		Scene scene = new Scene(root);
		stage.setTitle("XMAS Random");
		stage.setScene(scene);
		stage.show();
	}

	class Distribution implements EventHandler {

		@Override
		public void handle(Event event) {
			Textes t = new Textes(fieldL.getText());
			fieldR.setText("" + t.randomDistrib());
		}
	}

	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	
}
