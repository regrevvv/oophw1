package hw1.no1.ch3_16;
public class MatrixCalc {
	public static void main(String args[]) {
		MatrixCalc M = new MatrixCalc(3, 3);
		for(int i = 0, k = 1; i<3; i++)
		{
			for(int j = 0; j<3; j++, k++)
			{
				M.matrix[i][j]=k;
			}
		}
		M.printMatrix();
		System.out.println("-------------");
		M.transpose();
		M.printMatrix();
	}
	//멤버
	public double matrix[][];
	int row, col;
	//생성자, 멤버 matrix 를 row * col 행렬로 만듦
	public MatrixCalc(int row, int col) {
		this.matrix = new double[row][col];
		this.row = row;
		this.col = col;
	}
	
	public void printMatrix() {
		for(int i = 0; i < this.row; i++)
		{
			for(int j = 0; j <this.col; j++)
			{
				System.out.print(this.matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	//행렬 멤버 전치
	public void transpose() {
		double temp[][] = new double[this.row][this.col];
		for(int i = 0; i <this.row; i++) {
			for(int j = 0; j<this.col; j++) {
				temp[j][i] = this.matrix[i][j];
			}
		}
		this.matrix = temp;
	}
	
	public double determinant() {
		if(this.row != this.col)
			System.err.println("Not a square matrix!");
		return this.determinantRecursion();
	}
	
	public double determinantRecursion() {
		if(this.col > 3) {
			double det = 0.0;
			for(int j = 0; j<this.col; j++) {
				det += this.matrix[0][j] * this.cofactor(0, j);
			}
			return det;//TODO 수반행렬, 여인수
		}
		else if(this.col == 3) {
			return ((this.matrix[0][0] * this.matrix[1][1] * this.matrix[2][2])
					+ (this.matrix[0][1] * this.matrix[1][2]* this.matrix[3][0])
					+ (this.matrix[0][2] * this.matrix[1][0] * this.matrix[2][1])
					- (this.matrix[0][0] * this.matrix[1][2] * this.matrix[2][1])
					- (this.matrix[0][1] * this.matrix[1][0]* this.matrix[3][2])
					- (this.matrix[0][2] * this.matrix[1][1] * this.matrix[2][0])
					);
		}
		else if(this.col == 2) {
			return ((this.matrix[0][0] * this.matrix[1][1]) - (this.matrix[1][0]*this.matrix[0][1]));
		}
		else
			return this.matrix[0][0];
	}
	//여인수 반환
	private double cofactor(int i, int j) {
		//소행렬 만들기
		MatrixCalc minor = new MatrixCalc(this.row-1, this.col-1);
		for(int a = 0, b = 0; i<minor.row; a++, b++) {
			if(a==i)
				b++;
			for(int c = 0, d = 0; j<minor.col; c++, d++) {
				if(c==j)
					d++;
				minor.matrix[a][c] = this.matrix[b][d];
			}
		}
		//i, j 가 0부터 시작하지만 두 수의 합이 홀/짝인가에는 영향 없음
		return Math.pow(-1, (double)i+(double)j)*minor.determinant();
	}
	
	//역행렬이 수반행렬을 행렬식으로 나눈 값이라는 사실 이용
	private void inverse() {
		//수반행렬 선언
		MatrixCalc adjoint = new MatrixCalc(this.row, this.col);
		for(int i = 0; i < this.row; i++)
			for(int j = 0; j < this.col; j++) 
				adjoint.matrix[i][j] = this.cofactor(i, j);
		
		double det = this.determinant();
		for(int i = 0; i < this.row; i++)
			for(int j = 0; j < this.col; j++) 
				this.matrix[i][j] = adjoint.matrix[i][j] / det;	
	}
}
//DONE!