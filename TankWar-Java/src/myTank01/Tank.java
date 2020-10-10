package myTank01;

public class Tank {
	int x;
	int y;
	int z;//tank's direction
	public Tank(int x,int y,int z){
		this.y=y;
		this.x=x;
		this.z=z;
	}
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
