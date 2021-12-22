package sample;

public class Player {
    static int id=0;
    int cur_pos=0;
    int ID;
    Player(){
        this.ID=id;
        id++;
    }
    public void move_ahead(){
        this.cur_pos+=1;
    }

    //in case of no snakes and ladder at the location of the piece
    public void complete_move(int moves){
        for(int i=0;i<moves;i++){
            move_ahead();
        }
    }

    public void linear_move(){

    }

}
