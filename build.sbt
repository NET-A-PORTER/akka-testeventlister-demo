name := "Akka TestEventListener Demo"

version := "0.0.1"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-feature", "-language:postfixOps")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

val akka = "2.2.3"

libraryDependencies ++=
    "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime" ::
    "com.typesafe.akka" %% "akka-actor" % akka ::
    "com.typesafe.akka" %% "akka-slf4j" % akka ::
    "com.typesafe.akka" %% "akka-testkit" % akka % "test" ::
    "org.scalatest" %% "scalatest" % "2.0" % "test" ::
    Nil

