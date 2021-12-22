package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.animation.TranslateTransition;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javafx.util.Duration;

class Tile extends Rectangle{
    public Tile(int x,int y){
        setWidth(Controller.Tile_size);
        setHeight(Controller.Tile_size);
        setFill(Color.GRAY);
        setStroke(Color.BLACK);
    }
}

public class Controller {
    //end
    private Stage stage;
    private Scene scene;
    private Parent root;
    //trying dice roll + dice animation
    @FXML
    private ImageView dice;
    @FXML
    private Button roll;
    Random random=new Random();
    public void roll_click_P1(ActionEvent event){
        PLAYER1.setDisable(true);
        Thread thread=new Thread(){
            public void run() {
                int a=0;
                try{
                    for(int i=0;i<10;i++){
                        int ran_number=(random.nextInt(6)+1);
                        File file=new File("src/sample/dice images/dice" + ran_number+".png");
                        DICE.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(65);
                        a=ran_number;
                    }
                    PLAYER1.setDisable(false);
                    System.out.println(a);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        TranslateTransition translate=new TranslateTransition();
        translate.setByX(40);
        translate.setDuration(Duration.millis(500));
        translate.setNode(B_P);
        translate.play();
    }
    public void roll_click_P2(ActionEvent event){
        PLAYER2.setDisable(true);
        Thread thread=new Thread(){
            public void run() {
                int a=0;
                try{
                    for(int i=0;i<10;i++){
                        int ran_number=(random.nextInt(6)+1);
                        File file=new File("src/sample/dice images/dice" + ran_number+".png");
                        DICE.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(65);
                        a=ran_number;
                    }
                    PLAYER2.setDisable(false);
                    System.out.println(a);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        TranslateTransition translate=new TranslateTransition();
        translate.setByX(40);
        translate.setDuration(Duration.millis(500));
        translate.setNode(R_P);
        translate.play();
    }

    //dice code ends here

    @FXML
    //press start game btn and go to next stage where main game is present
    public void switchtomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("START.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static final int Tile_size=60;
    public static final int width=10;
    public static final int height=10;
//    private Group tilegroup =new Group();
//
//    private Parent grid_try() throws  Exception{
//        Parent root1 = FXMLLoader.load(getClass().getResource("GAME.fxml"));
//        StackPane root2=new StackPane();
//        root2.setPrefSize(width*Tile_size,(height*Tile_size)+50);
//        root2.getChildren().addAll(tilegroup);
//        for(int i=0;i<height;i++){
//            for(int j=0;j<width;j++){
//                Tile tile=new Tile(Tile_size,Tile_size);
//                tile.setTranslateX(j*Tile_size);
//                tile.setTranslateY(i*Tile_size);
//                tilegroup.getChildren().add(tile);
//            }
//        }
//        return root2;
//
//    }
    @FXML
    //back btn (to get back to main stage)
    public void switchtogame(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("grid.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    //rules button
    //alert box open dispalying the rules
    @FXML
    public void rules_reg(ActionEvent event) throws IOException{
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rules & Regulations");
        String info="- Each player puts their counter on the space that says 'start here' i.e the first space.\n" +
                "- Take it in turns to roll the dice. Move your counter forward the number of spaces shown on the dice.\n" +
                "- If your counter lands at the bottom of a ladder, you can move up to the top of the ladder.\n" +
                "- If your counter lands on the head of a snake, you must slide down to the bottom of the snake.\n" +
                "- The first player to get to the last space that says 'victory' is the winner.";
        alert.setContentText(info);
        alert.setHeaderText("How to play!!");
        alert.showAndWait();



    }
    @FXML
    public void exitgame_clicked(ActionEvent event) {
        Stage stage = (Stage)exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Button Startgame;
    @FXML
    private Button rules;
    @FXML
    public Button exit;
    @FXML
    private ImageView myimage1;
    @FXML
    private ImageView blue_piece;
    @FXML
    private ImageView maingame;
    @FXML
    private ImageView red_piece;
    @FXML
    private Button BACK;
    @FXML
    private Button PLAYER1;
    @FXML
    private Button PLAYER2;
    @FXML
    private ImageView DICE;
    @FXML
    private ImageView B_P;
    @FXML
    private ImageView R_P;





}
