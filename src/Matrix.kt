import java.util.Arrays

class IncompatibleMatricesException(message:String): Exception(message)

/**
 * Matrix class provides plus, multiply and transpose operations for matrices
 * Real number is a complex one with zero imaginary number
 */
class Matrix(nrows: Int, ncols: Int,
             data: Array<Array<ComplexNumber>> = Array(nrows) { Array(ncols, {i -> ComplexNumber(0, 0)}) }) {
    val nrows: Int
    val ncols: Int
    private val matrix: Array<Array<ComplexNumber>>

    init {
        this.nrows = nrows
        this.ncols = ncols
        matrix = Array(nrows, {i -> Array(ncols, {j -> ComplexNumber(data[i][j].re, data[i][j].im)}) })
    }

    override fun toString(): String {
        var result = ""
        for (arr in matrix) {
            result += Arrays.deepToString(arr) + "\n"
        }
        return result
    }

    operator fun get(i: Int, j: Int): ComplexNumber{
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: ComplexNumber) {
        matrix[i][j] = value
    }

    operator fun plus(matrix1: Matrix): Matrix {
        if (ncols != matrix1.ncols || nrows != matrix1.nrows) {
            throw IncompatibleMatricesException("Matrices have different number of rows or columns")
        }

        val resultMatrix = Matrix(nrows, ncols)
        matrix.forEachIndexed { i, array ->
            array.forEachIndexed { j, _ ->
                resultMatrix[i, j] = this[i, j] + matrix1[i, j]
            }
        }
        return resultMatrix
    }

    operator fun times(matrix1: Matrix): Matrix {
        if (nrows != matrix1.ncols || ncols != matrix1.nrows) {
            throw IncompatibleMatricesException("Matrices have incompatible number of rows or columns")
        }
        val resultMatrix = Matrix(nrows, matrix1.ncols)
        for (i in 0 until nrows) {
            for (j in 0 until matrix1.ncols) {
                for (k in 0 until ncols) {
                    resultMatrix[i, j] += this[i, k] * matrix1[k, j]
                }
            }
        }
        return resultMatrix
    }

    fun transpose(): Matrix {
        val resultMatrix = Matrix(ncols, nrows)
        for (i in 0 until nrows) {
            for (j in 0 until ncols) {
                resultMatrix[j, i] = this[i, j]
            }
        }
        return resultMatrix
    }
}