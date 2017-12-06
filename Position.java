public class Position {
	protected int x = 0;
	protected int y = 0;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Position) {
			Position other = (Position)o;
			return this.x == other.x && this.y == other.y;
		} else {
			return false;
		}
	}
}