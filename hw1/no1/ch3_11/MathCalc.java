package hw1.no1.ch3_11;
public class MathCalc {

	public static void main(String[] args) {
		int i = 3, j = 4, k = 5;
		float x = 3.45f, y = 6.0f;
		
		System.out.println("(a) " + (-x * -y * (i + j) / k));
		System.out.println("(b) " + ( i / 5 * y));
		System.out.println("(c) " + (y%x));
		System.out.println("(d) x = " + (x/i/y/j));
		System.out.println("(e) " + (Math.exp(j%i)));
		System.out.println("(f) " + (Math.pow(3, 2)));
		System.out.println("(g) " + Math.min(y, Math.max(i, k)));
		System.out.println("(h) " + Math.ceil(x)%i);
		System.out.println("(i) " + ((x+2.4)/(140.0*(i/j))));// (i/j) = 0
	}

}
