import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player2 extends Player {
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
    public Player2(World w, String name, Location location, int health, List<Thing> things, Thing goal) {
        super(w, name, location, health, things, goal);
    }
    boolean interacted =false;
    boolean tookflashlight=false;
    @Override
    public void interact(Player p){
        Scanner s = new Scanner(System.in);
        int option = 0;
        if(!interacted) {
            System.out.println("You approach the small kid wearing a cloak\n");
            System.out.println("\"Hey little kid, where's your mother?\"\n ");
            System.out.println(" *The kid takes out the dagger from under his cloak and slashes you with it* (-70 hp)");
            p.addHealth(-70);
            System.out.println("OUCH! What is wrong with you!!!\n");
            System.out.println("0. Take a chance and hit the kid!\n");
            System.out.println("1. Try to talk some sense into the kid!\n");
            option = s.nextInt();
            Random r = new Random();
            switch (option) {
                case 0:
                    if (r.nextInt(100) > 25) {
                        System.out.println("You hit the fragile kid and he dies instantly!");
                        p.addHealth(100);
                        System.out.println("You see some items dropping out of his bloody cloak!\n");
                        getWorld().getRoom(p).addThing(getWorld().newFlashlight(p.location));
                        getWorld().getRoom(p).addThing(getWorld().newHealthPotion(p.location));
                        getWorld().getRoom(p).removePlayer(this);
                    } else {
                        System.out.println("You miss and the kid manages to land another slash on you! (-70 health)\n");
                        p.addHealth(-70);
                    }
                    break;
                case 1:
                    if (r.nextInt(100) > 45) {
                        System.out.println("He apologizes, and offers you to take either his only potion, or a flashlight he found!\n");
                        System.out.println("*Think about this wisely! you might need the flashlight later, but then again you would need a good amount of health too!:)\n");
                        System.out.println("0. Take the potion and drink it!\n");
                        System.out.println("1. Take the flashlight.\n");
                        option = s.nextInt();
                        switch (option) {
                            case 0:
                                p.addHealth(30);
                                break;
                            case 1:
                                p.addThing(getWorld().newFlashlight(p.location));
                                break;
                        }
                    } else {
                        System.out.println("The kid gets even more angry at you and stabs you with his dagger!\n");
                        p.addHealth(-100);
                    }
                    break;
            }
            interacted=true;
        }else {
            System.out.println("Here for another round mister?\n");
            if (tookflashlight) {
                System.out.println("ENTER. No you got me good the last time, but can I have the health potion?\n");
                p.addThing(getWorld().newHealthPotion(p.location));
            }else{
                System.out.println("ENTER. No you got me good the last time, but can I have the flashlight?\n");
                p.addThing(getWorld().newFlashlight(p.location));
            }
            s.nextLine();
            System.out.println("FIIINE, take it I'm leaving anyways >.>\n");
            getWorld().getRoom(p).removePlayer(this);
        }
    }
    @Override
    public String getInteractOption() {
        return "Approach the kid!\n";
    }
}
