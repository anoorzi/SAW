
public class walk {
	
	private int x;
	private int y;
	
	public walk(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println(x);
		System.out.println(y);
	}
	
	public void setwalkx(int x) {
		this.x = x;
	}
	
	public void setwalky(int y) {
		this.y = y;
	}
	
	public int getwalkx() {
		return x;
	}
	
	public int getwalky() {
		return y;
	}
    public String toString() {
        return 
                "x=" + x  +
                " y=" + y;
    }
}