package sample;

import javafx.scene.Node;

public class Tunnel {
    private final int start;
    private Node player_image;
    private final int end;

    Tunnel(int s, int e){
        this.start=s;
        this.end=e;
    }

    public int getStart() {
        return start;
    }

    public void carry_player(Player P){
        P.linear_move(start,end);
    }

}
