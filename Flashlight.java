
public class Flashlight extends Thing {
	boolean isOn =false;
	public Flashlight(String name, Location location, int value, String description) {
		super(name, location, value, description);
	}
	public boolean turnOn = false;
	public final int force = 15;
	
		private Check on() {
			turnOn=true;
			return new Check(true, "Flashlight: On");
		}
		private Check off() {
			turnOn=false;;
			return new Check(false, "Who cut the lights out?");
		}
	public boolean isON(){
			return isOn;
	}
	@Override
	public void interact(Player p){
			isOn=!isOn;
	}
	@Override
	public String getInteractOption() {
		return isOn?"Turn off the flashlight":"Turn on the flashlight";
	}
}
