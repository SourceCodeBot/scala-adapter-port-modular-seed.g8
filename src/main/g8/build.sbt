// give the user a nice default project!
ThisBuild / organization := "$package$"
ThisBuild / scalaVersion := "$scalaVersion$"

lazy val root = (project in file(".")).
  settings(
    name := "$name$"
  ).aggregate(core, secondaryPort, primaryPort, secondaryAdapter, primaryAdapter)


lazy val core = (project in file("00-core"))

lazy val secondaryPort = (project in file("10-port-secondary")).dependsOn(core)

lazy val primaryPort = (project in file("20-port-primary")).dependsOn(core, secondaryPort)

lazy val secondaryAdapter = (project in file("30-adapter-secondary")).dependsOn(secondaryPort)

lazy val primaryAdapter = (project in file("40-adapter-primary")).dependsOn(secondaryAdapter, primaryPort)


