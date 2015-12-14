val org = "pl.edu.agh.iet"
val appVersion = "0.0.1-SNAPSHOT"

organization := org

name := "akka-tracing-visualization"

version := appVersion

lazy val root = (project in file(".")).dependsOn(uri("https://github.com/akka-tracing-tool/akka-tracing-core.git"))
  .enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
