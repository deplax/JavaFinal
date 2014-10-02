package tetris3;

public class Position implements Cloneable {
	private int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveDown() {
		y++;
	}

	public void moveUp() {
		y--;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}

	public void moveRotate() {
		int temp;
		temp = x;
		x = y;
		y = temp;
		y = y * -1;
	}

	public void moveRotateCW() {
		int temp;
		temp = x;
		x = y;
		y = temp;
		x = x * -1;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}

	// 절대좌표 계산용
	public void calcPosX(int absoluteX) {
		x += absoluteX;
	}

	public void calcPosY(int absoluteY) {
		y += absoluteY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Position) super.clone();
	}

}
