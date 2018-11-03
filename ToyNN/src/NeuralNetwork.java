
/**
 * <h1>Neural Network Library</h1>
 * Simple 3-layered neural network with an input layer,
 * a hidden layer, and an output layer
 * </br>
 * 
 * @author Bailey Pelletier
 * @version 0.0.1
 * @since 3 November 2018
 * 
 * 
 */
public class NeuralNetwork {
	
	//Instance variables
	private int input_nodes;
	private int hidden_nodes;
	private int output_nodes;
	
	private Matrix input;
	private Matrix hidden;
	private Matrix output;
	
	
	private Matrix weights_ih;
	private Matrix weights_ho;
	
	private Matrix b_ih;
	private Matrix b_ho;
	
	
	//Constructors
	/**
	 * Basic constructor for a 3-layered Neural Network
	 * @param input_nodes
	 * @param hidden_nodes
	 * @param output_nodes
	 */
	public NeuralNetwork (int input_nodes, int hidden_nodes, int output_nodes) {
		setInput_Nodes(input_nodes);
		setHidden_Nodes(hidden_nodes);
		setOutput_Nodes(output_nodes);
		
		initializeInput();
		initializeOutput();
		initializeHidden();
		
		initializeWeights_IH();
		initializeWeights_HO();
		
		initializeBias_IH();
		initializeBias_HO();
	}
	/**
	 * If passed no parameters, this constructor
	 * creates a linear neural network
	 */
	public NeuralNetwork() {
		this(1,1,1);
	}
	
	//toString & print
	/**
	 * Formats all the matrices into a String
	 */
	public String toString() {
		String s = "";
		
		s += "Input Matrix :\n" + getInput().toString() + "\n";
		s += "Hidden Matrix :\n" + getHidden().toString() + "\n";
		s += "Output Matrix :\n" + getOutput().toString() + "\n";
		
		s += "Weights_IH Matrix :\n" + getWeights_IH().toString() + "\n";
		s += "Weights_HO Matrix :\n" + getWeights_HO().toString() + "\n";
		
		s += "Bias_IH Matrix :\n" + getBias_IH().toString() + "\n";
		s += "Bias_HO Matrix :\n" + getBias_HO().toString() + "\n";
		
		
		return s;
	}
	/**
	 * Prints out all matrices of the neural network
	 */
	public void print() {
		System.out.println(this.toString());
	}
	
	//Simple Getters
	/**
	 * Gets number of Input nodes
	 * @return number of Input nodes
	 */
	public int getInput_Nodes() {
		return this.input_nodes;
	}
	/**
	 * Gets number of Hidden nodes
	 * @return number of Hidden nodes
	 */
	public int getHidden_Nodes() {
		return this.hidden_nodes;
	}
	/**
	 * Gets number of Output nodes
	 * @return number of Output nodes
	 */
	public int getOutput_Nodes() {
		return this.output_nodes;
	}
	
	/**
	 * Gets the Input matrix object
	 * @return vector matrix of input values
	 */
	public Matrix getInput() {
		return this.input;
	}
	/**
	 * Gets the Hidden Matrix object
	 * @return vector matrix of hidden values
	 */
	public Matrix getHidden() {
		return this.hidden;
	}
	/**
	 * Gets the Output matrix object
	 * @return vector matrix of output values
	 */
	public Matrix getOutput() {
		return this.output;
	}
	
	/**
	 * Gets the Weight matrix from input to hidden layers
	 * @return matrix of weight values from input to hidden layers
	 */
	public Matrix getWeights_IH() {
		return this.weights_ih;
	}
	/**
	 * Gets the Weight matrix from hidden to output layers
	 * @return matrix of weight values from hidden to output layers
	 */
	public Matrix getWeights_HO(){
		return this.weights_ho;
	}
	
	/**
	 * Gets the Bias vector from input to hidden layers
	 * @return matrix of weight values from input to hidden layers
	 */
	public Matrix getBias_IH(){
		return this.b_ih;
	}
	/**
	 * Gets the Bias vector from hidden to output layers
	 * @return matrix of weight values from hidden to output layers
	 */
	public Matrix getBias_HO(){
		return this.b_ho;
	}
	
	
	//Simple Setters
	/**
	 * Sets the number of input nodes.
	 * If param is less than 1, number of nodes is set to 1.
	 * @param i Number of nodes
	 */
	private void setInput_Nodes(int i) {
		if (i > 0)
			this.input_nodes = i;
		else
			this.input_nodes = 1;
	}
	/**
	 * Sets the number of hidden nodes.
	 * If param is less than 1, number of nodes is set to 1.
	 * @param i Number of nodes
	 */
	private void setHidden_Nodes(int i) {
		if (i > 0)
			this.hidden_nodes = i;
		else
			this.hidden_nodes = 1;
	}
	/**
	 * Sets the number of output nodes.
	 * If param is less than 1, number of nodes is set to 1.
	 * @param i Number of nodes
	 */
	private void setOutput_Nodes(int i) {
		if (i > 0)
			this.output_nodes = i;
		else
			this.output_nodes = 1;
	}
	
		// Creates & randomly initializes elements
	/**
	 * Creates and initializes vector matrix with random values
	 * between 0 and 1.
	 */
	public void initializeInput() {
		input = new Matrix(input_nodes, 1);
		input.initialRand();
	}
	/**
	 * Creates and initializes vector matrix based on the 
	 * array passed as the parameter.
	 * @param arr
	 */
	public void initializeInput(double[] arr) {		//Custom input
		input = Matrix.fromArrary(arr);
	}
	
	/**
	 * Creates a Zero vector for hidden layer
	 */
	public void initializeHidden() {
		hidden = new Matrix(hidden_nodes, 1);
	}
	/**
	 * Creates a Zero vector for output layer
	 */
	public void initializeOutput() {
		output = new Matrix(output_nodes, 1);
	}
	
	/**
	 * Creates and initializes Weight matrix between
	 * input and hidden layers with random values between 0 and 1.
	 */
	public void initializeWeights_IH() {
		weights_ih = new Matrix(getInput().getRows(), getHidden().getRows());
		weights_ih.initialRand();
	}
	/**
	 * Creates and initializes Weight matrix between
	 * hidden and output layers with random values between 0 and 1.
	 */
	public void initializeWeights_HO() {
		weights_ho = new Matrix(getHidden().getRows(), getOutput().getRows());
		weights_ho.initialRand();
	}
	
	/**
	 * Creates and initializes Bias vector between
	 * input and hidden layers with random values between 0 and 1.
	 */
	public void initializeBias_IH() {
		b_ih = new Matrix(getHidden().getRows(), 1);
		b_ih.initialRand();
	}
	/**
	 * Creates and initializes Bias vector between
	 * hidden and output layers with random values between 0 and 1.
	 */
	public void initializeBias_HO() {
		b_ho = new Matrix(getOutput().getRows(), 1);
		b_ho.initialRand();
	}
	
	
	//Predict Methods
	/**
	 * <h2>FeedForward Process</h2>
	 * Using current weights and inputs, calculates
	 * hidden layer values and then output layer values
	 */
	public void predict() {
		
		// H = W-ih(T) • I + B-ih
		hidden = Matrix.dot(getWeights_IH().getTranspose(), getInput());
		hidden = Matrix.add(hidden, getBias_IH());
		//Activation function on H
			//Sigmoid Function!
		for (int i = 0; i < hidden.getRows(); i++) {
			for (int j = 0; j < hidden.getCols(); j++) {
				
				double sig = 1.0 / (1 + Math.exp(-hidden.getElement(i, j)));
				
				hidden.setElement(i, j, sig);
			}
		}
		
		
		// A = W-ho(T) • H + B-ho
		output = Matrix.dot(getWeights_HO().getTranspose(), getHidden());
		output = Matrix.add(output, getBias_HO());
		//Activation function on A
			//Sigmoid Function!
		for (int i = 0; i < output.getRows(); i++) {
			for (int j = 0; j < output.getCols(); j++) {
				
				double sig = 1.0 / (1 + Math.exp(-output.getElement(i, j)));
				
				output.setElement(i, j, sig);
			}
		}
		
		
	}
	/**
	 * <h2>FeedForward Process</h2>
	 * Using current weights and user inputs, calculates
	 * hidden layer values and then output layer values.
	 * Returns output layer as an array.
	 * 
	 * @param inputArr
	 * @return array of output values
	 */
	public double[] predict(double[] inputArr) {
		
		input = Matrix.fromArrary(inputArr);
		
		predict();
		
		return Matrix.toArrary(output);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		NeuralNetwork nn = new NeuralNetwork(3,3,2);
		double[] myInput = {1,0,1};
		//nn.initializeInput(myInput);
		
		//nn.print();
		//System.out.println("****************");
		
		double[] myOutput = nn.predict(myInput);
		nn.print();
		
		System.out.println("My Input Array:");
		for (double val : myInput) {
			System.out.println(val + ", ");
		}
		System.out.println("\nMy Output Array:");
		for (double val : myOutput) {
			System.out.println(val + ", ");
		}

		
	}
}
