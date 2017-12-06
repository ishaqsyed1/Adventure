

public class HealthPotion extends Thing {
	public final int heal =30;
	public boolean Used = false;


	public HealthPotion(String name, Location location, int value, String description) {
		super("health Potion", location, value, "gives health");
		// TODO Auto-generated constructor stub
	}
	private Check Used(Player player ) {
		Used = true;
		player.addHealth(heal);
		this.setDescription("A empty health potion");
		return new Check(true, "You restored 40");
	}

	@Override
	public String getInteractOption() {
		return name;
	}
}


