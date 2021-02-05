class ComplexNumber (re: Int, im: Int) {
    var re: Int
    var im: Int
    init {
        this.re = re
        this.im = im
    }

    operator fun plus(c: ComplexNumber): ComplexNumber{
        return ComplexNumber(re + c.re, im + c.im)
    }

    operator fun times(c: ComplexNumber): ComplexNumber{
        return ComplexNumber(re * c.re - im * c.im, re * c.im + im * c.re)
    }

    override fun toString(): String = "$re + ${im}i"
}