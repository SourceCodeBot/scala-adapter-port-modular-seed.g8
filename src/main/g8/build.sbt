// give the user a nice default project!
ThisBuild / organization := "$package$"
ThisBuild / scalaVersion := "$scalaVersion$"

lazy val root = (project in file("."))
  .settings(
    name := "$name$"
  ).aggregate(core, secondaryPort, primaryPort, secondaryAdapter, primaryAdapter)
  .dependsOn(core, secondaryPort, primaryPort, secondaryAdapter, primaryAdapter)


lazy val core = (project in file("00-core"))
  .settings(
    name := "$name$-core"
  )

lazy val secondaryPort = (project in file("10-port-secondary"))
  .settings(
    name := "$name$-secondary-port"
  )
  .dependsOn(core)

lazy val primaryPort = (project in file("20-port-primary"))
  .settings(
    name := "$name$-primary-port"
  )
  .dependsOn(core, secondaryPort)

lazy val secondaryAdapter = (project in file("30-adapter-secondary"))
  .settings(
    name := "$name$-secondary-adapter"
  )
  .dependsOn(secondaryPort)

lazy val primaryAdapter = (project in file("40-adapter-primary"))
  .settings(
    name := "$name$-primary-adapter"
  )
  .dependsOn(secondaryAdapter, primaryPort)


