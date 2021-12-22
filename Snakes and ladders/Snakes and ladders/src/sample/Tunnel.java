package sample;

public class Tunnel {
    private final int start;
    private final int end;

    Tunnel(int s, int e){
        this.start=s;
        this.end=e;
    }

    public void carry_player(Player P){
        P.linear_move(start,end);
    }

}
