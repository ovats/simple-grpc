package com.gm.grpc.client

import com.gm.grpc.analyzetext.AnalyzeTextGrpc
import io.grpc.ManagedChannelBuilder

import java.util.logging.Logger

object AnalyzeTextClientApp {
  private val logger = Logger.getLogger(classOf[AnalyzeTextClient].getName)

  private def createGrpcClient(host: String, port: Int) = {
    val channel = ManagedChannelBuilder
      .forAddress(host, port)
      .usePlaintext(true)
      .build

    val blockingStub = AnalyzeTextGrpc.blockingStub(channel)
    new AnalyzeTextClient(channel, blockingStub)
  }

  def main(args: Array[String]): Unit = {
    val host = "localhost"
    val port = 50051
    logger.info(s"Starting AnalyzeTextClientApp ...")

    val client = createGrpcClient(host, port)

    try {
      client.sendMessage("this is a test")
    } finally {
      client.shutdown()
    }

  }

}
