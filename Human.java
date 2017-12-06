import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/** A human (user) players in the game */

public class Human extends Player{
  
  private static boolean verbose = true; // set true for debugging
  // set false for submitted code
  
  /** Creates a player in the game
    * 
    * @param w is the world that the player lives in
    * @param name is the name of the player
    * @param location is where in the world the player is
    * @param health is the health of the player (which may or may not be relevant in your game)
    * @param things is a list of Thing objects that the player initially possesses
    * @param goal is the Thing that the human player is trying to retrieve in the game
    */
  public Human(World w, String name, Location location, int health,
               List<Thing>  things, Thing goal){
    super(w, name, location, health, things, goal);
  }
  
  
  /** Plays a turn for this player
    * 
    * For computer players will have the AI for that player.
    * For human player querie user for input and then react 
    * appropriately for the input.
    */
  @Override
  public void play(){
    Room currentRoom = getWorld().getRoom(this);
    System.out.println(currentRoom.look());
    System.out.println("\nYour options are:\n");
    ArrayList<Option> options = getOptions();
    Scanner systemin=new Scanner(System.in);
    for(int i=0;i<options.size();i++){
      System.out.println(Integer.toString(i)+". "+options.get(i).text);
    }
    int option=Integer.parseInt(systemin.nextLine());
    options.get(option).apply();
  }
  
  
  public ArrayList<Option> getOptions(){
    ArrayList<Option> options=new ArrayList<>();
    Room currentRoom = getWorld().getRoom(this);
    for(Location i : currentRoom.adjacent){
      Room r=getWorld().getRoom(i);
      options.add(new MoveOption("Go to "+r.getDescription(),i));
    }
    for(Thing i : things){
      options.add(new InteractOption(i));
    }
    for(Player i: currentRoom.getPlayers()){
      options.add(new InteractOption(i));
    }
    for(Thing i:currentRoom.getThings()){
      options.add(new PickupOption(currentRoom,i));
    }
    return options;
  }
  public void look(){
    String s = "You are currently in ";
    s += w.getRoom(getLocation()).toString();
    System.out.println(s);
  }
  
  public void help(){
    String s = "Your options are:\n ";
    s += "'h' for help \n ";
    s += "'l' to look around the room \n ";
    s += "'g x' to go in direction x (x can be n,e,w,s) \n ";
    s += "'w' to list what you have \n ";
    System.out.println(s);
  }

  @Override
  public String getInteractOption() {
    return "The player";
  }

  abstract class Option{
    String text;
    public Option(String text){this.text=text;};
    abstract void apply();
  }

  class MoveOption extends Option{
    Location to;
    public MoveOption(String text,Location loc){
      super(text);
      to=loc;
    }

    @Override
    void apply() {
     location=to;
    }
  }
  class InteractOption extends Option{
    interactable item;
    public InteractOption(interactable item) {
      super(item.getInteractOption());
      this.item = item;
    }

    @Override
    void apply() {
      item.interact();
    }
  }
  class PickupOption extends Option{
    Thing thing;
    Room room;
    public PickupOption(Room room,Thing thing) {
      super("Pick up the "+thing.getName());
      this.thing=thing;
      this.room=room;
    }

    @Override
    void apply() {
      things.add(thing);
      room.things.remove(thing);
    }
  }

  
}