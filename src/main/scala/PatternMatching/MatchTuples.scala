def processCoordinates(input: Any): Unit = {
  input match {
    case (lat, long) => printf("Procssing (%d, %d)...", lat, long)
    case "done" => println("done")
    case _ => println("Invalid input")
  }
}

processCoordinates((39, -104))
processCoordinates("done")