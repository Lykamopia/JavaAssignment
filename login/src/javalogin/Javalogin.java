package javalogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class Javalogin extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage.setTitle("Login Page");
        Image image = new Image("C:\\Users\\NY\\Documents\\NetBeansProjects\\javalogin\\src\\javalogin\\images\\android.png");
        stage.getIcons().add(image);  //Set Icon for the App
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    public static void sceneFactory(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(Javalogin.class.getResource(fxml+".fxml"));
    }
}