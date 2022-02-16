import scalapb.compiler.Version.{grpcJavaVersion, scalapbVersion}

name := "simple-grpc"

version := "0.1"

scalaVersion := "2.12.4"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime"      % scalapbVersion % "protobuf",
  "io.grpc"               % "grpc-netty"           % grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapbVersion,
  "com.thesamet.scalapb" %% "scalapb-json4s"       % scalapbVersion,
)

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")
