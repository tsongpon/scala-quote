name := "scala-quote"

organization := "net.songpon"

version := "0.1.0"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8")

resolvers +=
  "Twitter" at "http://maven.twttr.com"

lazy val versions = new {
  val finatra = "2.2.0"
  val logback = "1.1.3"
  val guice = "4.0"
}

mainClass in Compile := Some("net.songpon.QuoteAPIMain")

assemblyMergeStrategy in assembly := {
  case x if x.startsWith("META-INF") => MergeStrategy.discard // Bumf
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

test in assembly := {}

libraryDependencies ++= Seq(
  "com.twitter" % "finatra-http_2.11" % versions.finatra exclude("com.twitter", "util-logging"),
  "com.twitter" % "finatra-slf4j_2.11" % versions.finatra,
  "com.twitter" % "finatra-jackson_2.11" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % "1.1.7",

  "org.jooq" % "jooq" % "3.7.1",
  "org.jooq" % "jooq-meta" % "3.7.1",
  "org.jooq" % "jooq-codegen" % "3.7.1",
  "org.jooq" % "jooq-scala" % "3.7.1",
  "com.zaxxer" % "HikariCP" % "2.4.3",
  // **** SQL Drivers
  "com.h2database" % "h2" % "1.4.190",
  "mysql" % "mysql-connector-java" % "5.1.38",

  "com.twitter" % "finatra-http_2.11" % versions.finatra % "test",
  "com.twitter" % "inject-server_2.11" % versions.finatra % "test",
  "com.twitter" % "inject-app_2.11" % versions.finatra % "test",
  "com.twitter" % "inject-core_2.11" % versions.finatra % "test",
  "com.twitter" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",
  "com.twitter" % "finatra-jackson_2.11" % versions.finatra % "test",
  "com.twitter" % "finatra-http_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter" % "inject-server_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter" % "inject-app_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter" % "inject-core_2.11" % versions.finatra % "test" classifier "tests",
  "com.twitter" % "inject-modules_2.11" % versions.finatra % "test" classifier "tests",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test" classifier "tests",
  "com.twitter" % "finatra-jackson_2.11" % versions.finatra % "test" classifier "tests",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yinline-warnings",
  "-Ywarn-dead-code",
  "-Xfuture")

initialCommands := "import net.songpon.scalaquote._"