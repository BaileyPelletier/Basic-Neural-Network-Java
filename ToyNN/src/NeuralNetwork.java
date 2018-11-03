
/**
 * <h1>Neural Network Library</h1>
 * Simple neural network
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
	
	public NeuralNetwork() {
		this(1,1,1);
	}
	
	//toString & print
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
	public void print() {
		System.out.println(this.toString());
	}
	
	//Simple Getters
	public int getInput_Nodes() {
		return this.input_nodes;
	}
	public int getHidden_Nodes() {
		return this.hidden_nodes;
	}
	public int getOutput_Nodes() {
		return this.output_nodes;
	}
	
	public Matrix getInput() {
		return this.input;
	}
	public Matrix getHidden() {
		return this.hidden;
	}
	public Matrix getOutput() {
		return this.output;
	}
	
	public Matrix getWeights_IH() {
		return this.weights_ih;
	}
	public Matrix getWeights_HO(){
		return this.weights_ho;
	}
	
	public Matrix getBias_IH(){
		return this.b_ih;
	}
	public Matrix getBias_HO(){
		return this.b_ho;
	}
	
	
	//Simple Setters
	private void setInput_Nodes(int i) {
		if (i > 0)
			this.input_nodes = i;
		else
			this.input_nodes = 1;
	}
	private void setHidden_Nodes(int i) {
		if (i > 0)
			this.hidden_nodes = i;
		else
			this.hidden_nodes = 1;
	}
	private void setOutput_Nodes(int i) {
		if (i > 0)
			this.output_nodes = i;
		else
			this.output_nodes = 1;
	}
	
		// Creates & randomly initializes elements
	public void initializeInput() {
		input = new Matrix(input_nodes, 1);
		input.initialRand();
	}
	public void initializeInput(double[] arr) {		//Custom input
		input = Matrix.fromArrary(arr);
	}
	
	public void initializeHidden() {
		hidden = new Matrix(hidden_nodes, 1);
	}
	public void initializeOutput() {
		output = new Matrix(output_nodes, 1);
	}
	
	public void initializeWeights_IH() {
		weights_ih = new Matrix(getInput().getRows(), getHidden().getRows());
		weights_ih.initialRand();
	}
	public void initializeWeights_HO() {
		weights_ho = new Matrix(getHidden().getRows(), getOutput().getRows());
		weights_ho.initialRand();
	}
	
	public void initializeBias_IH() {
		b_ih = new Matrix(getHidden().getRows(), 1);
		b_ih.initialRand();
	}
	public void initializeBias_HO() {
		b_ho = new Matrix(getOutput().getRows(), 1);
		b_ho.initialRand();
	}
	
	
	//Predict Methods
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
