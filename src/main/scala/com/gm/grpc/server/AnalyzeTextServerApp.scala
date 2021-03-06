package com.gm.grpc.server

import com.gm.config.AppConfig

import java.util.logging.Logger
import scala.concurrent.ExecutionContext.Implicits.global

object AnalyzeTextServerApp {
  private val logger = Logger.getLogger(classOf[AnalyzeTextServer].getName)

  def main(args: Array[String]): Unit = {
    val config: AppConfig = AppConfig()
    val port              = config.grpc.server.port

    logger.info("Starting AnalyzeTextServerApp ...")

    val server = new AnalyzeTextServer(port)
    server.start()
    server.blockUntilShutdown()
  }

}
