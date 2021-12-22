package sample;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Tunnel> tunnelList=new ArrayList<>();
    private Player p1=new Player();
    private Player p2=new Player();
    Game(){
        tunnelList.add(new Tunnel(11,9));
        tunnelList.add(new Tunnel(36,14));
        tunnelList.add(new Tunnel(56,18));
        tunnelList.add(new Tunnel(43,22));
        tunnelList.add(new Tunnel(90,50));
        tunnelList.add(new Tunnel(94,53));
        tunnelList.add(new Tunnel(75,54));
        tunnelList.add(new Tunnel(81,63));
        tunnelList.add(new Tunnel(96,65));
        tunnelList.add(new Tunnel(99,78));

        tunnelList.add(new Tunnel(4,25));
        tunnelList.add(new Tunnel(8,31));
        tunnelList.add(new Tunnel(21,60));
        tunnelList.add(new Tunnel(28,46));
        tunnelList.add(new Tunnel(32,48));
        tunnelList.add(new Tunnel(42,80));
        tunnelList.add(new Tunnel(52,68));
        tunnelList.add(new Tunnel(58,77));
        tunnelList.add(new Tunnel(69,93));
        tunnelList.add(new Tunnel(84,98));


    }
}
