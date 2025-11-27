import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class lab10_Q2 extends Application {

    @Override
    public void start(Stage stage) {

        Label message = new Label("Click the button");
        Button btn = new Button("Click Me");

        // Event Handling
        btn.setOnAction(e -> message.setText("Button Clicked!"));

        VBox layout = new VBox(15);
        layout.getChildren().addAll(message, btn);

        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Event Handling Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
