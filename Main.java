import java.io.File;
import java.io.FileNotFoundException;
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
		World world = new World(worldConfig);
	}
}
