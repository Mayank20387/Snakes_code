package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
//    public static final int tiles=80;
//    public static final int width=10;
//    public static final int height=10;
//    private Group tilegrp =new Group();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("START.fxml"));
//        Button btn=new Button("Roll dice");
//        BorderPane.setMargin(btn,new Insets(0,0,20,220));
        Scene scene=new Scene(root);
//        scene.getStylesheets().add("/src/sample/CSS/START.css");
//        primaryStage.setTitle("Snakes and Ladder");
//        primaryStage.setScene(new Scene(root, 550, 600));
//        scene.getStylesheets().add(getClass().getResource("START.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
