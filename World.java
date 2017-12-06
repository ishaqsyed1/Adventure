import java.util.ArrayList;

public class World{
	protected Room[][] rooms;
	protected Location entrance;
	protected Thing    goal;
	public World(){


	}

	public World(String worldFileName){
		// create world described in file worldFileName
		this();
		// Split the string into an array of lines
		String[] lines = worldFileName.split("[\\r\\n]+");
		Location[] roomLocations = new Location[]{new Location(this,0,0),new Location(this,1,0),new Location(this,1,1),new Location(this,0,1)};
		// initialize number of rooms
		int numberOfRooms = Integer.parseInt(lines[0]);
		rooms = new Room[numberOfRooms/2][2];
		entrance = new Location(this,0,0);
		// loop through the arrays while parsing the config file data
		for(int offset=0; offset < numberOfRooms; offset++) {
			int currentRoomNum = Integer.parseInt(lines[0 + 1 + (offset*5)]);

			String roomName = lines[ 1 + 1 + (offset*5)];
			String[] roomsList = (lines[2 + 1 + (offset*5)]).split(",");
			String [] playerNum = (lines[3 + 1 + (offset*5)]).split(",");
			String [] thingNum = (lines[4 + 1 + (offset*5)]).split(",");
			Location roomLocation=getRoomLocationFromID(currentRoomNum,numberOfRooms);
			ArrayList<Location> adjacentRooms = new ArrayList<Location>();
			for(int room=0; room < roomsList.length; room++) {
				int adjacentRoomNum = Integer.parseInt(roomsList[room].trim());

				Location adjRoomLocation = getRoomLocationFromID(adjacentRoomNum,numberOfRooms);
				adjacentRooms.add(adjRoomLocation);
			}
			ArrayList<Player> playerList = new ArrayList<Player>();
			for(int player=0; player < playerNum.length; player++) {
				int playerRoomNum = Integer.parseInt(playerNum[player].trim());

				for(int i=0;i<playerRoomNum;i++){
					Location playerLocation = new Location(this, roomLocation.row,roomLocation.col);
					switch (player){
						case 0:
							playerList.add(newPlayer0(playerLocation));
							break;
						case 1:
							playerList.add(newPlayer1(playerLocation));
							break;
						case 2:
							playerList.add(newPlayer2(playerLocation));
							break;
					}

				}


			}
			ArrayList<Thing> thingList = new ArrayList<Thing>();
			for(int thing=0; thing < thingNum.length; thing++) {
				int thingRoomNum = Integer.parseInt(thingNum[thing].trim());

				for(int i=0;i<thingRoomNum;i++){
					Location thingLocation = new Location(this, roomLocation.row,roomLocation.col);
					//HP=0,M8B=1,FL=2,TR=3
					switch (thing){
						case 0:
							thingList.add(newHealthPotion(thingLocation));
							break;
						case 1:
							thingList.add(newMagic8Ball(thingLocation));
							break;
						case 2:
							thingList.add(newFlashlight(thingLocation));
							break;
						case 3:
							thingList.add(newTresure(thingLocation));
							break;
					}

				}


			}

			Room room =new Room(roomName,roomLocation,
					adjacentRooms,
					playerList,
					new java.util.ArrayList<Thing>(),false);
			rooms[roomLocation.row][roomLocation.col]=room;
		}

		rooms[0][1].dark=true;
		rooms[0][1].addThing(newTresure(new Location(this,0, 0)));
	}
	Flashlight newFlashlight(Location l){
		return new Flashlight("Flashlight", l, 0, "Lol");
	}
	HealthPotion newHealthPotion(Location l){
		return new HealthPotion("Health Potion",l,0,"plehpleh");
	}
	Treasure newTresure(Location l){
		return new Treasure("tresure",l,0,"none");
	}

	Magic8Ball newMagic8Ball(Location l){
		return new Magic8Ball("Magic 8 ball", l, 0, "A magic 8 ball");
	}
	Player newPlayer0(Location l){
		return new Player0(this,"Tim the Tic Tac Toe Man",l,100,new ArrayList<Thing>(),null);
	}
	Player newPlayer1(Location l){
		return new Player1(this,"Jaafar the sad merchant",l,100,new ArrayList<Thing>(),null);
	}
	Player newPlayer2(Location l){
		return new Player2(this,"Shady the Kid",l,100,new ArrayList<Thing>(),null);
	}
	public Location getEntrance(){
		System.out.println("Changes");
		return entrance;
	}
	public Location getRoomLocationFromID(int id,int total){
		return new Location(this,(id-1)%(total/2),id>(total/2)?1:0);
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