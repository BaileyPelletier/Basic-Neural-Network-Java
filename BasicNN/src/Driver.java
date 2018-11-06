
public class Driver {

	public static void main(String[] args) {
		NeuralNetwork myNN = new NeuralNetwork(2,3,2);
		
		double[] inputs = {0, 1};
		double[] targets = {1,0};
		
		myNN.printSimple();
		System.out.println("************************");
		myNN.predict();
		myNN.printSimple();
	}

}
