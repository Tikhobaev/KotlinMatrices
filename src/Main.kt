fun main(args: Array<String>) {
    // data for matrices
    val arr = arrayOf(arrayOf(ComplexNumber(0, 0), ComplexNumber(1, 0), ComplexNumber(2, 0)),
                       arrayOf(ComplexNumber(1, 0), ComplexNumber(2, 0), ComplexNumber(3, 0)))
    val arr1 = arrayOf(arrayOf(ComplexNumber(0, 0), ComplexNumber(1, 0)),
                       arrayOf(ComplexNumber(1, 0), ComplexNumber(2, 0)),
                       arrayOf(ComplexNumber(2, 0), ComplexNumber(3, 0)))
    val arr2 = arrayOf(arrayOf(ComplexNumber(2, 0), ComplexNumber(3, 0)),
                       arrayOf(ComplexNumber(3, 0), ComplexNumber(4, 0)),
                       arrayOf(ComplexNumber(4, 0), ComplexNumber(5, 0)))

    // define matrices
    var matrix = Matrix(2, 3, arr)
    var matrix1: Matrix = Matrix(3, 2, arr1)
    var matrix2: Matrix = Matrix(3, 2, arr2)

    // print all of them
    println(matrix)
    println(matrix1)
    println(matrix2)

    // demo of operations with martices
    println("\nmatrix2 + matrix1\n" + (matrix2 + matrix1))
    println("matrix * matrix1:\n" + matrix * matrix1)
    println("Transposed matrix:\n" + matrix.transpose())

}