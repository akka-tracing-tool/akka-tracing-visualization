val org = "pl.edu.agh.iet"
val appVersion = "0.1"

organization := org

name := "akka-tracing-visualization"

version := appVersion

lazy val visualization = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

resolvers += Resolver.url("Akka Tracing", url("https://dl.bintray.com/salceson/maven/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "org.xerial" % "sqlite-jdbc" % "3.16.1",
  "pl.edu.agh.iet" %% "akka-tracing-core" % appVersion,
  "pl.edu.agh.iet" %% "akka-tracing-relational-db-collector" % appVersion, // Relational DBs
//  "pl.edu.agh.iet" %% "akka-tracing-couchdb-collector" % appVersion, // Couch DB
  "org.json4s" %% "json4s-ext" % "3.5.1"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
