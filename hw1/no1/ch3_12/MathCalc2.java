package hw1.no1.ch3_12;
public class MathCalc2 {

	static double disc(double a, double b, double c) {
		return Math.sqrt(b*b-4*a*c);
	}
	public static void main(String[] args) {
		System.out.println(disc(1.0, 5.0, 2.0));
	}

}
