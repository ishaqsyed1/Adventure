import java.util.ArrayList;

public class World{
  protected Room[][] rooms;
  protected Location entrance;
  protected Thing    goal;
  public World(){
    Room r1 = new Room("the entrance", new Location(this,0,0), 
                      new java.util.ArrayList<Location>(),
                      new java.util.ArrayList<Player>(),
                      new java.util.ArrayList<Thing>());
    Room r2 = new Room("a dark room", new Location(this,0,1), 
                      new java.util.ArrayList<Location>(),
                      new java.util.ArrayList<Player>(),
                      new java.util.ArrayList<Thing>());
    r1.getAdjacentRooms().add(r2.getLocation());
    r2.getAdjacentRooms().add(r1.getLocation());
  
    rooms = new Room[1][2];
    rooms[0][0] = r1;
    rooms[0][1] = r2;
    entrance = r1.getLocation();
  }
  
   public World(String worldFileName){
    // create world described in file worldFileName
	  
	 // Split the string into an array of lines
	String[] lines = worldFileName.split("[\\r\\n]+");
	
	// initialize number of rooms
	int numberOfRooms = Integer.parseInt(lines[0]);
	
	// loop through the arrays while parsing the config file data
	for(int offset=0; offset < numberOfRooms; offset++) {
		int currentRoomNum = Integer.parseInt(lines[0 + 1 + (offset*5)]);
		String roomName = lines[ 1 + 1 + (offset*5)];
		String[] roomsList = (lines[2 + 1 + (offset*5)]).split(", ");
		String [] playerNum = (lines[3 + 1 + (offset*5)]).split(" , ");
		String thingNum = (lines[4 + 1 + (offset*5)]);

		// displays the roomNumber as String
		System.out.println(currentRoomNum);
		// displays the roomName as String
		System.out.println(roomName);
		// displays the roomOptions as String
		System.out.println(roomsList);
		// displays the Players as String
		System.out.println(playerNum);
		// displays the things in room as String
		System.out.println(thingNum);
	// creates array from file for adjacent rooms
		ArrayList<Location> adjacentRooms = new ArrayList<Location>();
		for(int room=0; room < roomsList.length; room++) {
			int adjacentRoomNum = Integer.parseInt(roomsList[room]);
			Location adjRoomLocation = new Location(this, 0, 0);
			adjacentRooms.add(adjRoomLocation);
			
		ArrayList<Location> playerList = new ArrayList<Location>();
			for(int player=0; player < playerNum.length; player++) {
				int playerRoomNum = Integer.parseInt(playerNum[player]);
				Location playerLocation = new Location(this, 0,0);
				playerList.add(playerLocation);
			}
		}
		
		
		Room room =new Room(roomName, new Location(this,0,0), 
				adjacentRooms,
                new java.util.ArrayList<Player>(),
                new java.util.ArrayList<Thing>());
	}	
	
  }
  
  public Location getEntrance(){
	  System.out.println("Changes");
	  return entrance;
  }
  
  public Thing getGoal(){ return goal;}
  
  /** returns room of spcified Player */
  public Room getRoom(Player p){
    int r = p.getLocation().getRow();
    int c = p.getLocation().getCol();
    return rooms[r][c];
  }
  /** returns room of specified location 
    * 
    * @return the room that this is at this location in this world. 
    *         Returns null if there is no such room.
    */
  public Room getRoom(Location location){
    return rooms[location.getRow()][location.getCol()];
  }
}