import java.util.List;

/** This class holds non-player things in the world.
 *
 * This class should be abstract and team members should be
 * creating concrete subclasses.
 */
public abstract class Thing implements interactable{
 protected String       name;
 protected Location     location;
 protected int          value;
 protected String          description;
 protected boolean       seen;
 
 public Thing(String name, Location location, int value, String description)
 {
  this.name = name;
  this.location = location;
   this.value = value;
 }
 

 
 public String       getName(){ return name; }
 public Location     getLocation(){ return location; }
 public int          getValue(){ return value; }
 public String          getExtraField(){ return description;}
 
 public void setLocation(Location location){
  this.location = location;
 }
 
 public void setValue(int v){
  this.value = v;
 }

 public void setDescription(String description){
  this.description = description;
 }
 
 /** Allows for a Thing to interact with the room it is in (including all of the players and things in that room)
   */
 public void interact(){
   // allows for some interaction with room (and players/things in it)
 }
 
 /** Allows for interaction with thw current thing and a specified player 
   * 
   * @param p is a player that is interacting with this current thing
   */
 public void interact(Player p){
   // allows for some interaction with a player
 }
 public void interact(Thing t){
  return;
 }
 @Override
 public boolean equals(Object o){
   if( o instanceof Thing){
     return this.name.equals( ((Thing)o).name )  
            && this.location.equals( ((Thing)o).location ) 
            && this.value == ((Thing)o).value
            && this.description == ((Thing)o).description;
                                  
   }else{
     return false;
   }
 }
}