# Basic-Neural-Network-Java

This neural network is meant to be basic and simple in its design as it is a learning experience. Inlcuded in this repo is a Matrix class library that is also built from the ground-up. The basis of design for these libraries come from a similar repo, **[Toy-Neural-Network-JS](https://github.com/BaileyPelletier/Toy-Neural-Network-JS)**.

### ToDo:
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

## Matrix Class Documentation

|     Matrix      |
|--------|
| - rows: int |
| - cols: int |
| - data: double[][] |
|---|
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
|-- **STATIC** --|
| + fromArray(double[] arr): Matrix|
| + toArrary(Matrix a): double[]|
| + add(Matrix a, Matrix b): Matrix|
| + subtract(Matrix a, Matrix b): Matrix|
| + mult(Matrix a, Matrix b): Matrix  <--{HARDAMAN PRODUCT} |
| + dot(Matrix a, Matrix b): Matrix|
