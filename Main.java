import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("src/config.txt");
		Scanner input;
		String worldConfig = "";
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				worldConfig += input.nextLine() + "\n";
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		boolean won=false;
		while(!won) {

			World world = new World(worldConfig);
			Human m = new Human(world, "The player", new Location(world, 0, 0), 100, new ArrayList<Thing>(), null);

			System.out.println("Greetings traveller!\nWhat's a weary looking person like you doing here?");
			while (true) {
				m.play();
				if (m.health <= 0) {
					System.out.println("You died!!!\nRestarting...\n\n\n\n\n\n");
					break;
				}
				if(m.location.row==0&&m.location.col==0&&m.hasTresure()){
					System.out.println("Congrats!!! you beat the game!");
					won=true;
					break;
				}

			}
		}
	}
}
