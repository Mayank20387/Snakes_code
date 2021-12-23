package sample;
import sample.Player;
import sample.Tunnel;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Tunnel> tunnelList=new ArrayList<>();
    Game(){
        tunnelList.add(new Snakes(11,9));
        tunnelList.add(new Snakes(36,14));
        tunnelList.add(new Snakes(56,18));
        tunnelList.add(new Snakes(43,22));
        tunnelList.add(new Snakes(90,50));
        tunnelList.add(new Snakes(94,53));
        tunnelList.add(new Snakes(75,54));
        tunnelList.add(new Snakes(81,63));
        tunnelList.add(new Snakes(96,65));
        tunnelList.add(new Snakes(99,78));

        tunnelList.add(new Ladders(4,25));
        tunnelList.add(new Ladders(8,31));
        tunnelList.add(new Ladders(21,60));
        tunnelList.add(new Ladders(28,46));
        tunnelList.add(new Ladders(32,48));
        tunnelList.add(new Ladders(42,80));
        tunnelList.add(new Ladders(52,68));
        tunnelList.add(new Ladders(58,77));
        tunnelList.add(new Ladders(69,93));
        tunnelList.add(new Ladders(84,98));


    }
}
