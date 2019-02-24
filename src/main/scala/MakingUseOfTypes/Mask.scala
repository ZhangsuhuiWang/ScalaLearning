import MyInterpolator._

class Mask {
  val ssn = "123-456-789"
  val account = "0246813579"
  val balance = 12345.6

  println(mask"""Account: $account
                |Social Security Number: $ssn
                |Balance: $$^$balance
                |Thanks for your business.""".stripMargin)
}


