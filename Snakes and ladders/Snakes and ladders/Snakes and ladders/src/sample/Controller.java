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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javafx.util.Duration;
public class Controller {
    //end
    @FXML
    private ImageView B_P;
    @FXML
    private ImageView R_P;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView dice;
    @FXML
    private Button roll;
    Random random=new Random();
    static Player p1;
    static Game g;
    public void roll_click_P1(ActionEvent event) throws IOException {
      Main.trying();
        PLAYER2.setDisable(false);
        PLAYER1.setDisable(true);
        Thread thread = new Thread() {
            int num = 0;

            public void run() {
                int a = 0;
                try {
                    for (int i = 0; i < 10; i++) {
                        int ran_number = (random.nextInt(6) + 1);
                        File file = new File("src/sample/dice images/Dice" + ran_number + ".jpeg");
                        DICE.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(55);
                        a = ran_number;
                    }
                    PLAYER1.setDisable(false);
                    System.out.println(a);
                    p1.complete_move(a);
                    for (int i = 0; i < g.tunnelList.size(); i++) {
                        if (g.tunnelList.get(i).getStart() == p1.getCur_pos()) {
                            g.tunnelList.get(i).carry_player(p1);
                        }
                    }
                    PLAYER1.setDisable(true);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    static Player p2;
    public void roll_click_P2(ActionEvent event) throws IOException {
        Main.trying();
        PLAYER1.setDisable(false);
        PLAYER2.setDisable(true);
        Thread thread=new Thread() {
            public void run() {
                int a = 0;
                try {
                    for (int i = 0; i < 10; i++) {
                        int ran_number = (random.nextInt(6) + 1);
                        File file = new File("src/sample/dice images/dice" + ran_number + ".jpeg");
                        DICE.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(55);
                        a = ran_number;
                    }
                    PLAYER2.setDisable(false);
                    System.out.println(a);
                    p2.complete_move(a);
                    for (int i = 0; i < g.tunnelList.size(); i++) {
                        if (g.tunnelList.get(i).getStart() == p2.getCur_pos()) {
                            g.tunnelList.get(i).carry_player(p2);
                        }
                    }
                    PLAYER2.setDisable(true);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
    @FXML
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

    @FXML
    public void switchtogame(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("grid.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        ImageView ib = (ImageView) scene.lookup("#B_P");
        ImageView ir = (ImageView) scene.lookup("#R_P");
        ImageView ar = (ImageView) scene.lookup("#arrow");
        p1=new Player(ib);
        p2=new Player(ir);
        g=new Game();
        ar1(ar);
        }
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
    static void ar1(ImageView image){
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(image);
        translate.setDuration(Duration.seconds(0.82));
        translate.setToY(20);
//        translate.setToX(10);
        translate.setAutoReverse(true);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }
    @FXML
    private AnchorPane scene1pane;
    @FXML
    private static ImageView arrow;
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
    private GridPane GRID;
    @FXML
    private Button exit_final;
}
