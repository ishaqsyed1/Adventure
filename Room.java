import java.util.List;
import java.util.Random;

public class Room{
  protected String         description;
  protected Location       location;
  protected List<Location> adjacent;
  protected List<Player>   people;
  protected List<Thing>    things;
  protected boolean dark;
  public Room(String description, Location location, List<Location> adjacent,
              List<Player> people, List<Thing> things,boolean isDark)
  {
    this.description = description;
    this.location = location;
    this.adjacent = adjacent;
    this.people = people;
    this.things = things;
    //this variable kinda acts like a light switch, the look function will tell you what is in the room only if it's true
    dark=isDark;
  }
  
  /* getters */
  public Location       getLocation(){ return location; }
  public List<Location> getAdjacentRooms(){ return adjacent; }
  public List<Player>   getPlayers(){ return people; }
  public List<Thing>    getThings(){ return things; }
  public String getDescription(){return description;}
  public boolean isDark(){return dark;}
  public String look(boolean flashlightOn){

    // return a string describing the room 
    // (what is in it, what exits you have, etc)
    String[] itemLocationOptions =new String[]{"on the","lying on the"};
    String[] itemPreOptions = new String[]{"you a notice a <name>\n","there's a <name>\n","after a closer look, you find a <name>\n","holy guacamole there's a <name>\n"," wowzers you found a <name>\n"};
    String tresure = "Oh would you look at that, a chest full of gold waiting just for you!!!";

    String[] peoplePre = new String[] {"Sitting in a corner you find <name>\n","\"It stinks in here, it's probably because <name> is sleeping over there\"\n","\"Big room? battle music in the background?! Someone must be here!\"" +
            "\n *looks around* \n It's <name>\n"};
    StringBuilder b = new StringBuilder();

    Random r = new Random();
    if(dark&&!flashlightOn){
      b.append("\nThe lights seem to be off, Maybe if you have a flashlight or something you'll be able to see?");
    }else{
      if(people.size()>0){
        b.append("\n\nIt seems that there's people in the room...\n");
        for(Player i : people){
          b.append(peoplePre[r.nextInt(peoplePre.length)].replace("<name>",i.getName()));
        }
      }
      if(things.size()>0){
        for(Thing i: things){
          b.append(itemPreOptions[r.nextInt(itemPreOptions.length)].replace("<name>",i.getName()));
          b.append(itemLocationOptions[r.nextInt(itemLocationOptions.length)]);
          b.append(" ground.");
        }
      }
    }
    if(dark&&!flashlightOn){
      b.append("\n\nIt seems the only door you can see is the one you came from...");
    }
    return b.toString();
  }
  
  
  public void addPlayer(Player p){
    this.people.add(p);
  }
  
  public void removePlayer(Player p){
    this.people.remove(p);
  }
  
  /** add a thing t to the current room */
  public void addThing(Thing t){
    this.things.add(t);
  }



  @Override
  public String toString(){
    return description;
  }
}