name := "Ejemplos"

version := "0.1"

scalaVersion := "2.12.7"

lazy val akkaVersion = "2.5.20"

libraryDependencies += "org.scalamock" %% "scalamock" % "4.1.0" % Test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % akkaVersion

