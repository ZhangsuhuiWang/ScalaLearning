name := "ScalaLearning"

version := "0.1"

scalaVersion := "2.12.8"
lazy val akkaVersion = "2.5.21"
libraryDependencies ++= Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.6")
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)
libraryDependencies += "junit" % "junit" % "4.8.2"