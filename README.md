# Basic-Neural-Network-Java

![GIF from the movie Terminator](https://media.giphy.com/media/1j9f6wCFelOwzbGyoa/giphy.gif)

This neural network is meant to be basic and simple in its design as it is a learning experience. Inlcuded in this repo is a Matrix class library that is also built from the ground-up. The basis of design for these libraries come from a similar repo, **[Toy-Neural-Network-JS](https://github.com/BaileyPelletier/Toy-Neural-Network-JS)**. However, the libraries built in this repo expand upon the JavaScript versions and utilizes Java concepts as I learn them. As stated before, this is a personal project for educational purposes. 

#### Table of Contents
- ToDo List
- Matrix Class Library Documentation
- Neural Network Class Library Documentation


#### ToDo:
- [ ] **Build Matrix Class Library**
   - [x] Accessor/Mutator (Getter/Setter) Methods for Rows & Cols
   - [x] Constructors & from/toArray methods & toString()
   - [x] Initialization Methods (Random & Simple)
   - [x] Determinant & Matrix Minor (Took me ALL NIGHT!) derivation methods 
   - [x] Matrix Operations!
   - [ ] Finish Documentation
   - [ ] Future features & methods? (Subspaces, orthogonality, etc)
   - [ ] ~~Create mapFunc() Method~~ (Wanted to create a method that would take in a method as parameter. Turns out, requires concepts I'm not familiar with. Will revisit!
- [ ] **Build Neural Network Class Library**
   - [x] Set up instance variables
   - [x] Set up constructor(s)
   - [x] toString() or print() method
   - [x] Initialize weights and biases
   - [x] Predict method - AKA FeedForward
   - [x] Activation Functions - Hard-coded sigmoid function into predict()
   - [ ] Add .setLearningRate() for gradient descent calculations in .train()
   - [ ] Training method .train(input, target) - Gradient Descent & Back Propagation
      - [x] Feed Forward method
      - [ ] Calculate Errors and Cost Function
      - [ ] Calulcate gradient descent and deltas for Weight and Bias matrices
      - [ ] Back-Propagation: Apply deltas to Weigths and Biases
   - [ ] Documentation
- [ ] **Test Libraries**
   - [ ] XOR Problem
- [ ] **Add Visualization**

![GIF saying "This is too much"](https://media.giphy.com/media/l3q2Ph0I1osaagoQE/giphy.gif)

</br>
</br>
</br>

## Matrix Class Documentation

![GIF from the movie Matrix](https://media.giphy.com/media/QS0KOjNRG0tfG/giphy.gif)

### Matric UML Class Diagram
|     Matrix      |
|--------|
| - rows: int |
| - cols: int |
| - data: double[][] |
|--------------------------------------------------------------|
| + toString(): String|
| + initialRand(): void|
| + initialRandInt(): void|
| + initialSimple(): void|
| + getRows(): int|
| + getCols(): int|
| + getElement(int i, int j): double|
| + isSquare(): boolean|
| + getDeterm2x2(): double|
| + getDeterm(): double|
| + getMinorMatrix(int iRow, int jCol): Matrix|
| + getTranspose(): Matrix|
| + getInverse(): Matrix|
| + setRows(int i): void|
| + setCols(int j): void|
| + setElement(int i, int j, double val): void|
| + add(double amount): void|
|--------------------------------------------------------------|
|------------------------ **STATIC** ----------------------------|
| + fromArray(double[] arr): Matrix|
| + toArrary(Matrix a): double[]|
| + add(Matrix a, Matrix b): Matrix|
| + subtract(Matrix a, Matrix b): Matrix|
| + mult(Matrix a, Matrix b): Matrix  <--{HARDAMAN PRODUCT} |
| + dot(Matrix a, Matrix b): Matrix|


## Neural Network Class Documentation

### Neural Network UML Class Diagram
|     Neural Network      |
|--------|
| - input_nodes: int |
| - hidden_nodes: int |
| - output: double[][] |
| - input: Matrix |
| - hidden: Matrix |
| - output: Matrix |
| - weights_ih: Matrix |
| - weights_ho: Matrix |
| - b_ih: Matrix |
| - b_ho: Matrix |
|--------------------------------------------------------------|
| + toString(): String|
| + print(): void|
| + getInput_Nodes(): int|
| + getHidden_Nodes(): int|
| + getOutput_Nodes(): int|
| + getInput(): Matrix|
| + getHidden(): Matrix|
| + getOutput(): Matrix|
| + getWeights_IH(): Matrix|
| + getWeights_HO(): Matrix|
| + getBias_IH(): Matrix|
| + getBias_HO(): Matrix|
| - setInput_Nodes(int i): void|
| - setHidden_Nodes(int i): void|
| - setOutput_Nodes(int i): void|
| - initializeInput(): void|
| + initializeInput(double[]): void|
| - initializeHidden(): void|
| - initializeOutput(): void|
| - initializeWeights_IH(): void|
| - initializeWeights_HO(): void|
| - initializeBias_IH(): void|
| - initializeBias_HO(): void|
| + predict(): void|
| + predict(double[]): double[]|
