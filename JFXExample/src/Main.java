import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Created by Refi on 24.01.2017.
 */
public class Main extends Application {

    private Button printStuff;
    private Scene scene;

    public static void main (String[] args){
        launch(args);


    }
    /**
     * Lag et nytt StackPane(layout)
     * Lag nye komponenter
            * Legg komponentene til i layoutet.
     * Lag en ny scene og send inn layoutet som parameter.
            * set scenen i primaryStaget.
     * Vis primaryStaget.
     *
     * @param   primaryStage    hele vinduet som skal kjøres
     *
     */
    public void start(Stage primaryStage) {

        try {
            primaryStage.setTitle("MONOPOLY");

            StackPane layout = new StackPane();
            printStuff = new Button("Balance");
            printStuff.setMaxWidth(150);
            printStuff.setMaxHeight(150);

            layout.getChildren().add(printStuff);
            layout.setId("pane");

            scene = new Scene(layout, 1000, 1000);
            setBackgroundImg();
            //scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
            printStuff.setOnAction(e -> System.out.println(Board.getBalance()));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Load a background image
     */
    private void setBackgroundImg(){
        scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
    }



}
