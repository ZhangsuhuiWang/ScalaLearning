class Person(val firstName: String, val lastName: String)
object Person {
  def apply(firstName: String, lastName: String): Person =
    new Person(firstName, lastName)
}

val friends = List(Person("Brian", "Sletten"), Person("Neal", "Ford"),
  Person("Scott", "Davis"), Person("Stuart", "Halloway"))

val lastName = for(friend <- friends)
  yield friend.lastName
println(lastName.mkString(", "))