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
- add the classes for the client in the package `com.gm.grpc.client`.

## Run

Start the server:

`sbt "runMain com.gm.grpc.server.AnalyzeTextServerApp"`.

To run the client:

`sbt "runMain com.gm.grpc.client.AnalyzeTextClientApp"`.


## Improvements/enhancements

- update `sbt` version. => updated to 1.5.7.
- update `scala` version. => updated to 2.12.5.
- update dependencies versions.
- use PureConfig for parameters.