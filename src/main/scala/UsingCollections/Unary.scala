class Sample {
  def unary_+(): Unit = println("Called unary +")
  def unary_-(): Unit = println("Called unary -")
  def unary_~(): Unit = println("Called unary ~")
  def unary_!(): Unit = println("Called unary !")
}

val sample = new Sample
+sample
-sample
~sample
!sample

