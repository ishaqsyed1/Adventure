import java.util.List;
import java.util.Scanner;
public class Player1 extends Player{
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
    public Player1(World w, String name, Location location, int health, List<Thing> things, Thing goal) {
        super(w, name, location, health, things, goal);
    }

    @Override
    public void interact(Player p){
        System.out.println("You approach the sad merchant, you ask:");
        System.out.println("0. Why are you sad?");
        System.out.println("1. Hey, you got any potions?!");
        Scanner s =new Scanner(System.in);
        int option = s.nextInt();
        switch (option){
            case 0:
                System.out.println("I'm fine thanks for asking, it's just that my wife left me...");
                System.out.println("What do you seek traveller?");
                System.out.println("0. A potion?");
                System.out.println("1. Nothing I'm just lost");
                option = s.nextInt();
                switch (option) {
                    case 0:
                            System.out.println("Here's a potion dear fellow! Enjoy time your time in freggin place :)");
                            p.addThing(getWorld().newHealthPotion(p.location));
                        break;
                    case 1:
                            System.out.println("Bugger off!!! Don't waste my time");
                            System.out.println("*He throws some weird dust at you!* (-10 HP)");
                            p.addHealth(-10);
                        break;
                }
                break;
            case 1:
                System.out.println("Can't you see i'm not in the mood for filth like you!");
                System.out.println("*He throws some weird liquid at you!* (-30 HP)");
                p.addHealth(-30);
                break;
        }
        System.out.println("The magician packs his belongings and leaves...");
        getWorld().getRoom(p).removePlayer(this);
    }
    @Override
    public String getInteractOption() {
        return name;
    }
}
