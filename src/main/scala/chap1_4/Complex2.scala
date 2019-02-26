class Complex2(val real:Int, val imaginary:Int) {
  def +(operand: Complex2): Complex2 = {
    println("Calling +")
    new Complex2(real + operand.real, imaginary + operand.imaginary)
  }

  def *(operand: Complex2):Complex2 = {
    println("Calling *")
    new Complex2(
      real * operand.real - imaginary * operand.imaginary,
      real * operand.imaginary + imaginary * operand.real
    )
  }

  override def toString:String = {
    val sign = if(imaginary < 0) "" else "+"
    s"$real$sign${imaginary}i"
  }
}

val c1 = new Complex2(1,4)
val c2 = new Complex2(2,-3)
val c3 = new Complex2(2,2)
println(c1 + c2 * c3)
