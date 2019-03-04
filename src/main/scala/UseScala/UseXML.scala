val xmlFragment =
  <symbols>
    <symbol ticker="AAPL"><units>200</units></symbol>
    <symbol ticker="IBM"><units>215</units></symbol>
  </symbols>

println(xmlFragment)
println(xmlFragment.getClass)
println("------------------------")
var symbolNodes = xmlFragment \ "symbol"
symbolNodes foreach{println}
println(symbolNodes.getClass)
println("------------------------")
var unitsNodes = xmlFragment \\ "units"
unitsNodes foreach{println}
println(unitsNodes.getClass)
println(unitsNodes.head.text)
unitsNodes.head match {
  case <units>{ numbereOfUnits }</units> => println(s"Units: $numbereOfUnits")
}
println("------------------------")
println("Ticker\tUnits")
xmlFragment match {
  case <symbols>{ symbolNode @ _* }</symbols> =>
    for (symbolNode @ <symbol>{_* }</symbol> <- symbolNodes) {
      println("%-7s %s".format(
        symbolNode \ "@ticker", (symbolNode \ "units").text))
    }
}
