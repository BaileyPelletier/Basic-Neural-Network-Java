import java.text.DecimalFormat;

/**
 * <h1>Matrix Library</h1>
 * Custom Java library built to provide Matrix math and
 * operations for simple neural network
 * </br>
 * 
 * @author Bailey Pelletier
 * @version 0.1.0
 * @since 3 November 2018
 * 
 * 
 */
public class Matrix {
	
	//Instance Variables
	private int rows;
	private int cols;
	private double[][] data;
	
	//Constructors & Related
	/**
	 * Constructs a Zero matrix with the given parameters.
	 * Will construct a matrix with m leading ones with m
	 * representing the number of rows in an mxn matrix. 
	 *
	 * @param rows	Number of rows
	 * @param cols	Number of columns
	 * @param ident	Sets if constructor builds identity matrix
	 */
	public Matrix (int rows, int cols, boolean ident) {
		this.setRows(rows);
		this.setCols(cols);
		data = new double[rows][cols];
		
		if (ident) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (i == j) {
						this.setElement(i, j, 1.0);
					} else {
						this.setElement(i, j, 0.0);
					}
				}
			}
		} else {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					this.setElement(i, j, 0.0);
				}
			}
		}
	}
	/**
	 * Constructs a Zero matrix with the given parameters 
	 *
	 * @param rows	Number of rows
	 * @param cols	Number of columns
	 */
	public Matrix (int rows, int cols) {
		this(rows, cols, false);
	}
	
	/**
	 * Returns a vector matrix based on a 1D Array 
	 *
	 * @param arr		1D Array to be converted to column vector
	 * @return matrix	Column vector represented as a matrix (nx1)
	 */
	public static Matrix fromArrary(double[] arr) {
 		Matrix mat = new Matrix(arr.length, 1);
		for (int i = 0; i < mat.getRows(); i++) {
			mat.setElement(i, 0, arr[i]);
		}
		return mat;
	}
	
	/**
	 * Returns an array based on a column vector 
	 *
	 * @param a				Column vector matrix (nx1)
	 * @return arr[]		1D Array
	 */
	public static double[] toArrary(Matrix a) {
		double[] arr = new double[a.getRows()];
		
		for (int i = 0; i < a.getRows(); i++) {
			arr[i] = a.getElement(i, 0);
		}
		
		return arr;
	}
	/**
	 * Returns a String representation of a matrix object
	 * 
	 * @return string	String representing each element
	 */
	public String toString() {
		DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();
        decimalFormatObj.setMinimumFractionDigits(3);
        decimalFormatObj.setMaximumFractionDigits(3);
		String s = "";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < cols; j++) {
				s += decimalFormatObj.format(this.data[i][j]) + "\t";
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
	 * Initializes each value of a matrix between 0 and 10
	 * Truncated when casted to ints
	 * 
	 */
	public void initialRandInt() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.setElement(i, j, ((int)(Math.random()*10)));
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
		double det = 0.0;
		
		if (this.isSqaure() && this.getRows() == 2) {
			det = (this.getElement(0,0) * this.getElement(1, 1)) - (this.getElement(0, 1) * this.getElement(1, 0));
		} else {
			System.out.println("This matrix is not square or is not a 2x2 matrix!\n"
					+ "Returning 0.0 as determinant...");
		}
		
		return det;
	}
	
	/**
	 * Calculates and returns determinant of a matrix
	 * 
	 * @return det	The determinant of a matrix
	 */
	public double getDeterm() {
		double det = 0.0;
				
		if (this.isSqaure()) {
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
		} else {
			System.out.println("This matrix is not square!\n"
					+ "Returning 0.0 as determinant...");
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
	
	/**
	 * Returns a transposed matrix based on calling object
	 * 
	 * @return matrix	Transposed matrix
	 */
	public Matrix getTranspose() {
		Matrix trans = new Matrix(this.getCols(), this.getRows());
		
		for (int j = 0; j < this.getCols(); j++) {
			for (int i = 0; i < this.getRows(); i++) {
				trans.setElement(j, i, this.getElement(i, j));
			}
		}
		
		return trans;
	}

	/**
	 * Returns the inverse of the calling Matrix object
	 * </br>* Currently only works with 2x2 Matricies!
	 * 
	 * @return matrix	Inversed matrix
	 */
	public Matrix getInverse() {
		Matrix inverse = new Matrix(this.getRows(), this.getCols());
		
		if (this.isSqaure() && this.getDeterm() != 0) {
			
			if (this.getRows() == 2) {
				inverse.setElement(0, 0, this.getElement(1, 1));
				inverse.setElement(0, 1, -this.getElement(0, 1));
				inverse.setElement(1, 0, -this.getElement(1, 0));
				inverse.setElement(1, 1, this.getElement(0, 0));
				
				inverse.mult(1/this.getDeterm());
			}
			
			
		} else {
			System.out.println("This matrix is not invertible!\n"
					+ "Returning a Zero " + inverse.getRows() + "x" + inverse.getCols() + " Matrix...");
		}
		
		return inverse;
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

	/**
	 * Adds elements of two matrices with the same
	 * dimensions and returns the sum.
	 * 
	 * @param a 		Row index
	 * @param b 		Col index
	 * @return matrix 	Value to set to
	 */
	public static Matrix add(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.getRows(),a.getCols());
		
		if (a.getRows() == b.getRows() && a.getCols() == b.getCols()) {
			for (int i = 0; i < a.getRows(); i++) {
				for (int j = 0; j < a.getCols(); j++) {
					c.setElement(i, j, (a.getElement(i, j) + b.getElement(i, j)));
				}
			}
		} else {
			System.out.println("Matrices don't have the same dimensions! \n"
					+ "Returning zero matrix with dimensions of matrix A...");
		}
		
		return c;
	}
	/**
	 * Subtracts elements of two matrices with the same
	 * dimensions and returns the sum.
	 * c = (a - b)
	 * 
	 * @param a 		Row index
	 * @param b 		Col index
	 * @return matrix 	Value to set to
	 */
	public static Matrix subtract(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.getRows(),a.getCols());
		
		if (a.getRows() == b.getRows() && a.getCols() == b.getCols()) {
			for (int i = 0; i < a.getRows(); i++) {
				for (int j = 0; j < a.getCols(); j++) {
					c.setElement(i, j, (a.getElement(i, j) - b.getElement(i, j)));
				}
			}
		} else {
			System.out.println("Matrices don't have the same dimensions! \n"
					+ "Returning zero matrix with dimensions of matrix A...");
		}
		
		return c;
	}
	/**
	 * Adds a certain number to each element in a matrix
	 * 
	 * @param amount	Amount to add to each cell
	 */
	public void add(double amount) {
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.setElement(i, j, (this.getElement(i, j) + amount));
			}
		}
	}

	/**
	 * Multiplies every entry by a scalar
	 * 
	 * @param scalar	Scalar to multiply by
	 */
	public void mult(double scalar) {
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.setElement(i, j, (this.getElement(i, j) * scalar));
			}
		}
	}
	
	/**
	 * Returns the Hadamard product of two matricies.
	 * Each element is multiplied by its respective element
	 * of the other matrix
	 * 
	 * @param a	1st Matrix
	 * @param b 2nd Matrix
	 * @return matrix Hadamard Product
	 */
	public static Matrix mult(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.getRows(),a.getCols());
		
		if (a.getRows() == b.getRows() && a.getCols() == b.getCols()) {
			for (int i = 0; i < a.getRows(); i++) {
				for (int j = 0; j < a.getCols(); j++) {
					c.setElement(i, j, (a.getElement(i, j) * b.getElement(i, j)));
				}
			}
		} else {
			System.out.println("Matrices don't have the same dimensions! \n"
					+ "Returning zero matrix with dimensions of matrix A...");
		}
		
		return c;
	}
	
	/**
	 * Returns the dot product between mxn and nxk
	 * matricies. # of columns of first matrix must
	 * match # of rows second matrix.
	 * 
	 * @param a	1st Matrix
	 * @param b 2nd Matrix
	 * @return matrix Dot product
	 */
	public static Matrix dot(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.getRows(),b.getCols());
				
		if (a.getCols() == b.getRows()) {
			
			for (int i = 0; i < c.getRows(); i++) {
				for (int j = 0; j < c.getCols(); j++) {
					
					double cij = 0.0;
					
					for (int k = 0; k < a.getCols(); k++) {
						cij += a.getElement(i, k) * b.getElement(k, j);
					}

					//Now in c(ij)
					c.setElement(i, j, cij);
					
				}
			}
			
		} else {
			System.out.println("Matrices don't have the correct dimensions! \n"
					+ "Returning zero matrix with dimensions (" + a.getRows() + "x" + b.getCols() + ")...");
		}
		
		return c;
	}

	
	
	
	
	public static void main(String[] args) {
		
		Matrix a = new Matrix(2,2);
		a.initialRandInt();
		
		System.out.println(a.toString());
		System.out.println("Determinant: " + a.getDeterm() + "\n");
		
		Matrix aInv = a.getInverse();
		System.out.println(aInv.toString());
		
		
	}
}
