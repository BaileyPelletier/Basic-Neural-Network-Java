# Toy-Neural-Network-Java

<p>This neural network is meant to be basic and simple in its design as it is a learning experience. Inlcuded in this repo is a Matrix class library that is also built from the ground-up. The basis of design for these libraries come from a similar repo, <b><a href="https://github.com/BaileyPelletier/Toy-Neural-Network-JS">Toy-Neural-Network-JS.</a></b></p> 

ToDo:
- [ ] **Build Matrix Class Library**
   - [x] Accessor/Mutator (Getter/Setter) Methods for Rows & Cols
   - [x] Constructors & from/toArray methods & toString()
   - [x] Initialization Methods (Random & Simple)
   - [x] Determinant & Matrix Minor (Took me ALL NIGHT!) derivation methods 
   - [x] Matrix Operations!
   - [ ] Create Documentation
   - [ ] Future features & methods? (Subspaces, orthogonality, etc)
- [ ] **Build Neural Network Class Library**
- [ ] **Test Libraries**
- [ ] **Add Visualization**

<!--
<div>
  <p>Steps:</p>
  <ul>
    <li><b>Build Matrix Library    <i>(in progress...)</i></b>
      <ul>
        <li><del>Accessor/Mutator (Getter/Setter) Methods for Rows & Cols</del></li>
        <li><del>Constructors & from/toArray methods & toString()</del></li>
        <li><del>Initialization Methods (Random & Simple)</del></li>
        <li><del>Determinant & Matrix Minor (Took me ALL NIGHT!) derivation methods </del></li>
        <li><del>Matrix Operations!</del></li>
        <li>Create Documentation</li>
        <li>Future features & methods? (Subspaces, orthogonality, etc)</li>
      </ul>
    </li>
    <li>Build Neural Network Library</li>
    <li>Test libraries</li>
    <li>Add visualization?</li>
  </ul>
</div>
-->

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
