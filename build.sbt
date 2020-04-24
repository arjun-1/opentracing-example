
ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "opentracing-example",
    libraryDependencies ++= Seq(
      "io.opentracing"         % "opentracing-api" % "0.33.0",
      "io.opentracing"         % "opentracing-noop" % "0.33.0",
      "io.opentracing"         % "opentracing-mock" % "0.33.0",
      "io.jaegertracing"       % "jaeger-core" % "1.2.0"
    )
  )

