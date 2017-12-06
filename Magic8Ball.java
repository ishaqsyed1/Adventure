import java.util.Random;

public class Magic8Ball extends Thing implements interactable{
    public Magic8Ball(String name, Location location, int value, String description) {
        super(name, location, value, description);
    }
    @Override
    public void interact(Player p) {
        Random r= new Random();
        System.out.println("Drumroll...");
        switch (r.nextInt(3)){
            case 0:
                System.out.println("Too confident, let's fix that (-25 hp)");
                p.addHealth(-25);

                break;
            case 1 :
                System.out.println("Ahh a dark path awaits... here's some help (+50 hp)");
                p.addHealth(50);
                break;
            case 2:
                System.out.println("Try again :(");
                break;
        }
    }
    @Override
    public String getInteractOption() {
        return "Shake the magic 8 ball";
    }
}
