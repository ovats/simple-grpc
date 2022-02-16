# simple-grpc

This is my first try with gRPC using Scala.

## Project setup

- add `protoc.sbt` under `project` folder.
- add dependencies in `build.sbt`
- setup protobuf options in `build.sbt`

## Implementation

- create the definition of the service and messages under `root/src/main/protobuf`.
- run `sbt compile` to generate the classes for protobuf.
- classes will be generated in the folder `target/scala-x.yz/src_managed`.
- add the classes for the server in the package `com.gm.grpc.server`.

## Run

Start the server:

`sbt "runMain com.gm.grpc.server.AnalyzeTextServerApp"`

## Improvements/enhancements

- update `sbt` version.
- update `scala` version.
- update dependencies versions.
