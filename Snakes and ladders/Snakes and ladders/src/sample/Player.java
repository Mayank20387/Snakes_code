package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Player {
    private static int id=0;
    private Node player_image;
    private int cur_pos=0;
    private int ID;
    private boolean ready;

    Player(){   //image
        this.ID=id;
        id++;
        this.ready=false;
    }
    public void move_ahead(){
        linear_move(cur_pos,cur_pos+1);
    }

    //in case of no snakes and ladder at the location of the piece
    public void complete_move(){
        int dice_no=3;
        //1/ game start -1
        //gaming
        //<=100
//        if(!ready){
//            if(dice_no==1){
//                ready=true;
//
//            }
//            else{
//
//            }
//        }
        for(int i=0;i<dice_no;i++){

            move_ahead();
        }
    }

    public void linear_move(int prev_pos,int next_pos){
        //translate transition
        int r=0,c=0;
        int x1=0,y1=0;
        int x2=20,y2=20;
        TranslateTransition translate=new TranslateTransition();
        translate.setFromX(x1);
        translate.setFromY(y1);
        translate.setToX(x2);
        translate.setToY(y2);
        translate.setDuration(Duration.millis(500));
        translate.setNode(player_image);
        translate.play();
        this.cur_pos=next_pos;
    }

}
