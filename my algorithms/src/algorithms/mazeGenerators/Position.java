package algorithms.mazeGenerators;

public class Position {
	
	private int x;
	private int y;
	private int z;
	
	public Position (int x,int y,int z){
	
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	//getters and setters 
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
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	@Override 
	public String toString() {
		return "(" + x + "," + y + ","+ z + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			throw new IllegalArgumentException("Object must be position");
		
		Position p = (Position)obj;
		if(this.getX()==p.getX() && this.getY() == p.getY() && this.getZ() == p.getZ())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
