package com.gm.grpc.client

import com.gm.grpc.analyzetext.AnalyzeTextGrpc.AnalyzeTextBlockingStub
import com.gm.grpc.analyzetext.TextRequest
import io.grpc.{ManagedChannel, StatusRuntimeException}

import java.util.concurrent.TimeUnit
import java.util.logging.{Level, Logger}

class AnalyzeTextClient(channel: ManagedChannel, blockingStub: AnalyzeTextBlockingStub) {
  private val logger = Logger.getLogger(classOf[AnalyzeTextClient].getName)

  def shutdown(): Unit = {
    channel.shutdown.awaitTermination(5, TimeUnit.SECONDS)
  }

  def sendMessage(text: String): Unit = {
    logger.info(s"Sending $text to server ...")

    val request = TextRequest(message = text)
    try {
      val response = blockingStub.analyzeText(request)
      logger.info(s"Response: ${response.message}")
    } catch {
      case e: StatusRuntimeException =>
        logger.log(Level.WARNING, s"RPC failed: ${e.getStatus.toString}")
    }
  }

}
