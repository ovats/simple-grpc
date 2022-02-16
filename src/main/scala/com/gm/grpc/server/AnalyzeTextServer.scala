package com.gm.grpc.server

import com.gm.grpc.analyzetext.AnalyzeTextGrpc
import io.grpc.ServerBuilder

import java.util.logging.Logger
import scala.concurrent.ExecutionContext

class AnalyzeTextServer(port: Int)(implicit executionContext: ExecutionContext) { self =>
  private val logger = Logger.getLogger(classOf[AnalyzeTextServer].getName)

  private lazy val server = ServerBuilder
    .forPort(port)
    .addService(AnalyzeTextGrpc.bindService(new AnalyzeTextService, executionContext))
    .build

  def start(): Unit = {
    server.start
    logger.info(s"Server started, listening on $port")

    sys.addShutdownHook {
      self.stop()
    }
  }

  def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }

}
