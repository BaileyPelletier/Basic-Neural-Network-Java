
public class Driver {

	public static void main(String[] args) {
		NeuralNetwork myNN = new NeuralNetwork(2,3,2);
		
		myNN.print();
		myNN.predict();
		myNN.print();
	}

}
