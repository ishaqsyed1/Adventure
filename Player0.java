import TTT.TTTGame;

import java.util.List;

public class Player0 extends Player {
    /**
     * Creates a player in the game
     *
     * @param w        is the world that the player lives in
     * @param name     is the name of the player
     * @param location is where in the world the player is
     * @param health   is the health of the player (which may or may not be relevant in your game)
     * @param things   is a list of Thing objects that the player initially possesses
     * @param goal     is the Thing that the human player is trying to retrieve in the game
     */
    public Player0(World w, String name, Location location, int health, List<Thing> things, Thing goal) {
        super(w, name, location, health, things, goal);
    }
    @Override
    public void interact(Player p){
        System.out.println("I've never lost a Tic-Tac-Toe game in my life!");
        TTTGame t =new TTTGame(3,false,true);
        int result = t.Start();
        if(result==1){
            System.out.println("You Win!!");
            w.getRoom(this).addThing(getWorld().newMagic8Ball(p.location));
            w.getRoom(this).removePlayer(this);
        }else if(result==0){
            System.out.println("A draw...");
        }else if(result==-1){
            System.out.println("You lose..");
            p.health-=50;
        }
    }
    @Override
    public void interact(){
        interact(this);
    }
    @Override
    public String getInteractOption() {
        return "Talk to "+name;
    }
}
