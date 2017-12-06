

public class HealthPotion extends Thing {
	public final int heal =30;
	public boolean Used = false;


	public HealthPotion(String name, Location location, int value, String description) {
		super("health Potion", location, value, "gives health");
		// TODO Auto-generated constructor stub
	}
	public void interact(Player p){
		Used = true;
		p.addHealth(heal);
		this.setDescription("A empty health potion");
		System.out.println("Mmmhmm that health potion sure is delicious ("+Integer.toString(heal)+" HP)");
		p.removeThing(this);
	}

	@Override
	public String getInteractOption() {
		return "Drink health potion";
	}
}


