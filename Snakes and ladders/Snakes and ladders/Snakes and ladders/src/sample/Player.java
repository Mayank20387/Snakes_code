package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {
    private static int id=0;
    private ImageView player_image;
    private int cur_pos=0;
    private int ID;
    private boolean ready;

    Player(ImageView img){   //image
        this.player_image=img;
        this.ID=id;
        id++;
        this.ready=false;
    }
    static void dummy(ImageView img){
    }
    public void move_ahead(){
        linear_move(cur_pos,cur_pos+1);
    }

    public int getCur_pos() {
        return cur_pos;
    }

    //in case of no snakes and ladder at the location of the piece
    public void complete_move(int dice_no){
        if(!ready){
            if(dice_no==1 && cur_pos+dice_no<=100){
                ready=true;
                player_image.setLayoutX(159);
                player_image.setLayoutY(528);
                cur_pos+=1;
            }
        }
        else{
            if(cur_pos+dice_no<=100){
                for(int i=0;i<dice_no;i++){
                    move_ahead();
                }

            }
        }

    }

    public int[] calculate(int n){
        int q,r;
        int[] coordinates = new int[2];
        int i,j;
        q=n/10;
        r=n%10;
        if(r==0){
            i=q-1;
            if(q%2==0){
                j=0;
            }
            else{
                j=9;
            }
        }
        else{
            i=q;
            if(q%2==0){
                j=r-1;
            }
            else{
                j=9-r+1;
            }
        }
        coordinates[0]=i;
        coordinates[1]=j;
        return coordinates;
    }

    public void linear_move(int prev_pos,int next_pos){
        //translate transition
//        int r=0,c=0;
        int[] coordinate1=calculate(prev_pos);
        int[] coordinate2 =calculate(next_pos);
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(player_image);
        translate.setFromX(coordinate1[1]*39.2);
        translate.setFromY(-coordinate1[0]*56.8);
        translate.setToX(coordinate2[1]*39.2);
        translate.setToY(-coordinate2[0]*56.8);
        translate.setDuration(Duration.millis(2000));
        translate.play();
        this.cur_pos=next_pos;
    }

}