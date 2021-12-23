package sample;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;
import static sample.Controller.p1;
import static sample.Controller.p2;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("START.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    static void trying() throws IOException {

        if(p1.getCur_pos()==100){
            if(p1.getCur_pos()==100 || p1.getCur_pos()>=100){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("YOU WON");
                String info = "- CONGRATULATION PLAYER 1 YOU WON!!!!!";
                alert.setContentText(info);
                alert.setHeaderText("WIN!!!!!!");
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);

                if (button == ButtonType.OK) {
                    System.out.println("PLAYER 1 WON");
                    Platform.exit();

                }

            }
        }
        if(p2.getCur_pos()==100){
            if(p2.getCur_pos()==100 || p2.getCur_pos()>=100) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("YOU WON");
                String info = "- CONGRATULATION PLAYER 2 YOU WON!!!!!";
                alert.setContentText(info);
                alert.setHeaderText("WIN!!!!!!");
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);

                if (button == ButtonType.OK) {
                    System.out.println("PLAYER 2 WON");
                    Platform.exit();

                }
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
