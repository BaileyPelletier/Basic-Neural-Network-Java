/**
 * 
 * @author Bailey Pelletier </br>
 *
 *@
 *
 */


public class Matrix {
	
	//Instance Variables
	private int rows;
	private int cols;
	private double[][] data;
	
	//Constructors
	/**
	 * Constructs a Zero matrix with the given parameters 
	 *
	 * @param rows	Number of rows
	 * @param cols	Number of columns
	 */
	public Matrix (int rows, int cols) {
		this.setRows(rows);
		this.setCols(cols);
		
		data = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.setElement(i, j, 0.0);
			}
		}
	}
	
	public static Matrix fromArrary(double[] arr) {
		Matrix mat = new Matrix(arr.length, 1);
		for (int i = 0; i < mat.getRows(); i++) {
			mat.setElement(i, 0, arr[i]);
		}
		return mat;
	}
	
	/**
	 * Returns a String representation of a matrix object
	 * 
	 * @return string	String representing each element
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < cols; j++) {
				s += this.data[i][j] + "\t";
			}
			s += "\n";
		}
		return s;
	}
	
	/**
	 * Initializes each value of a matrix between 0 and 10
	 * Rounds to 3 decimal places
	 * 
	 */
	public void initialRand() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.setElement(i, j, ((int)(Math.random()*10 * 1000))/1000.0);
			}
		}
	}
	
	/**
	 * Initializes each value of a matrix starting at 1 and counting up
	 * 
	 */
	public void initialSimple() {
		int count = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.setElement(i, j, count);
				count++;
			}
		}
	}

	
	//Getters
	
	/**
	 * Gets and returns number of rows
	 * 
	 * @return rows	Number of rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Gets and returns number of cols
	 * 
	 * @return cols	Number of cols
	 */
	public int getCols() {
		return cols;
	}
	
	/**
	 * Gets and returns a specific element from array
	 * 
	 * @param i	ith row (starting at 0)
	 * @param j	jth col (starting at 0)
	 */
	public double getElement(int i, int j) {
		return this.data[i][j];
	}

	/**
	 * Returns true if matrix is square
	 * 
	 * @return boolean	If matrix is square
	 */
	public boolean isSqaure() {
		return (this.rows == this.cols);
	}

	
	//Derivations
	
	
	/**
	 * Calculates and returns determinant of a 2x2 matrix
	 * 
	 * @return det The determinant of a 2x2 matrix
	 */
	public double getDeterm2x2() {
		double det = 0.123;
		
		det = (this.getElement(0,0) * this.getElement(1, 1)) - (this.getElement(0, 1) * this.getElement(1, 0));
		
		
		return det;
	}
	
	/**
	 * Calculates and returns determinant of a matrix
	 * 
	 * @return det	The determinant of a matrix
	 */
	public double getDeterm() {
		double det = 0.0;
				
			if(this.rows == 2) {
				det = getDeterm2x2();
				
			} else if (this.rows >= 3) {
				int n = this.rows;
				int sign = 1;
				
				for (int i = 0; i < n; i++) {
					det += sign * getElement(0,i) * getMinorMatrix(0,i).getDeterm();
					sign *= -1;
				}
			}
		
		
		
		
		return det;
	}
	
	/**
	 * Returns a minor matrix Aij based on matrix passed in
	 * 
	 * @param iRow ith Row to eliminate
	 * @param jCol jth Col to eliminate
	 * @return matrix	Minor matrix
	 */
	public Matrix getMinorMatrix(int iRow, int jCol) {
		Matrix b = new Matrix(this.getRows()-1, this.getCols()-1);
		
		int bi = 0;
		for (int i = 0; i < this.getRows() ; i++) {
			
			if (i != iRow) {
				int bj = 0;
				for (int j = 0; j < this.getCols(); j++) {
					if (j != jCol) {
						b.setElement(bi, bj, this.getElement(i, j));
						bj++;
					}
				}
				bi++;
			}
		}
		
		return b;
	}
	
	
	//Setters
	
	/**
	 * Sets number of rows in matrix
	 * 
	 * @param i Number of rows
	 */
	public void setRows(int i) {
		this.rows = i;
	}

	/**
	 * Sets number of columns in matrix
	 * 
	 * @param j Number of columns
	 */
	public void setCols(int j) {
		this.cols = j;
	}

	/**
	 * Sets value of specific element in matrix
	 * 
	 * @param i Row index
	 * @param j Col index
	 * @param val Value to set to
	 */
	public void setElement(int i, int j, double val) {
		this.data[i][j] = val;
	}


	//Matrix Operations



	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*Matrix a = new Matrix(3,3);
		a.initialRand();
		System.out.println(a.toString());

		
		System.out.println("Matrix a has " + a.getRows() + " row(s) and "
				+ a.getCols() + " column(s).");
		if (a.isSqaure()) {
			System.out.println("Matrix a is square");
		} else {
			System.out.println("Matrix a is not square");
		}
		System.out.println();
		
		System.out.println("The value at 0,0 is: " + a.getElement(0, 0));
		System.out.println("The value at 0,0 will be changed to 5.999.");
		a.setElement(0, 0, 5.999);
		System.out.println("The new value at 0,0 is: " + a.getElement(0, 0));
		System.out.println(a.toString());
		*/
		
//		Matrix b = new Matrix(2,2);
//		b.setElement(0, 0, 1);
//		b.setElement(0, 1, 2);
//		b.setElement(1, 0, 3);
//		b.setElement(1, 1, 4);
//		double detr = b.getDeterm();
//		
//		System.out.println(b.toString());
//		System.out.println(b.isSqaure());
//		System.out.println(detr);
		
//		Matrix orig = new Matrix(3,3);
//		orig.initialRand();
//		System.out.println(orig.toString());
		
//		Matrix minor = orig.getMinorMatrix(1, 0);
//		System.out.println(minor.toString());
		
//		System.out.println("The determinant is: " + orig.getDeterm());
//		
//		Matrix vect = new Matrix(3,1);
//		vect.initialSimple();
//		System.out.println(vect.toString());
		
		double[] horVect = {3,7,2};
		Matrix vector = Matrix.fromArrary(horVect);
		System.out.println(vector.toString());
		
	}
}
