class WIFI(name:String) {
  override def toString: String = name
}

def connectToNetwork(user: String) (implicit wifi:WIFI):Unit = {
  println(s"User: $user connected to WIFI $wifi")
}

def atOffice(): Unit = {
  println("--- at the office ---")
  implicit def officeNetwork: WIFI = new WIFI("office-network")
  val cafeteriaNetwork = new WIFI("cafe-connect")

  connectToNetwork("guest")(cafeteriaNetwork)
  connectToNetwork("Jill Coder")
  connectToNetwork("Joe Hacker")
}

def atJoesHome(): Unit = {
  println("--- at Joe's home ---")
  implicit def homeNetwork: WIFI = new WIFI("home-network")

  connectToNetwork("guest")(homeNetwork)
  connectToNetwork("Joe Hacker")
}

atOffice()
atJoesHome()

