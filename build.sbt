import scalapb.compiler.Version.{grpcJavaVersion, scalapbVersion}

name := "simple-grpc"

version := "0.1"

scalaVersion := "2.12.5"

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value
)

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime"      % scalapbVersion % "protobuf",
  "io.grpc"               % "grpc-netty"           % grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapbVersion,
  "com.thesamet.scalapb" %% "scalapb-json4s"       % scalapbVersion,
)

ThisBuild / scalacOptions ++= Seq("-unchecked", "-deprecation")
