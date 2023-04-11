package sample02;

public class CalcAdd implements Calc {
	private int x, y; 
	
	
	public CalcAdd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	@Override
	public void calculate() {
		System.out.println(x + "+" + y + "=" +(x+y));

	}

}
