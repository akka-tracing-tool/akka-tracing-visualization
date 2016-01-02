val org = "pl.edu.agh.iet"
val appVersion = "0.0.2"

organization := org

name := "akka-tracing-visualization"

version := appVersion

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

resolvers += Resolver.url("Akka Tracing", url("https://dl.bintray.com/salceson/maven/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "org.xerial" % "sqlite-jdbc" % "3.8.11.1",
  "com.zaxxer" % "HikariCP-java6" % "2.3.3",
  "pl.edu.agh.iet" %% "akka-tracing-core" % "0.0.2"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
