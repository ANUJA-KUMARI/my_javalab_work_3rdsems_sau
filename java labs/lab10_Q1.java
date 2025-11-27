import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class lab10_Q1 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // First Window
        Label label1 = new Label("This is Window 1");
        StackPane root1 = new StackPane(label1);
        Scene scene1 = new Scene(root1, 300, 200);

        primaryStage.setTitle("Window 1");
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Second Window
        Stage secondStage = new Stage();
        Label label2 = new Label("This is Window 2");
        StackPane root2 = new StackPane(label2);
        Scene scene2 = new Scene(root2, 300, 200);

        secondStage.setTitle("Window 2");
        secondStage.setScene(scene2);
        secondStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
