public class Treasure extends Thing {
    public Treasure(String name, Location location, int value, String description) {
        super(name, location, value, description);
    }

    @Override
    public void interact(Player p){
        System.out.println("You open the box and you find the treasure so mesmerizing that you can't look away O.O");
        System.out.println("10 Days Later.");
        p.addHealth(-100);
    }
    @Override
    public String getInteractOption() {
        return "Stare at the treasure O.O";
    }
}
