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
        if(!ready){
            if(dice_no==1){
                ready=true;
                move_ahead();
            }
        }
        else{
            for(int i=0;i<dice_no;i++){
                move_ahead();
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
        int r=0,c=0;
        int[] coordinate1=calculate(prev_pos);
        int[] coordinate2 =calculate(next_pos);
        //coordinate1[0]-coordinate2[0]*tile_size+coordinate1[0]
        int x1=0,y1=0;
        int x2=20,y2=20;
        TranslateTransition translate=new TranslateTransition();
        translate.setFromX(coordinate1[0]*39.2);
        translate.setFromY(coordinate1[1]*56.8);
        translate.setToX(coordinate2[0]*39.2);
        translate.setToY(coordinate2[0]*56.8);
        translate.setDuration(Duration.millis(500));
        translate.setNode(player_image);
        translate.play();
        this.cur_pos=next_pos;
    }

}
