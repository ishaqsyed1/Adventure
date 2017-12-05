
public class Check {
	public boolean check;
	public String reason;
	
	public Check(boolean check, String Reason) {
		this.check = check;
		this.reason= reason;
		
	}
	public boolean equals(boolean test) {
		if(test== this.check) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public String toString() {
		return reason;
	}

}
