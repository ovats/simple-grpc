package com.gm.grpc.server

import com.gm.grpc.analyzetext.AnalyzeTextGrpc.AnalyzeText
import com.gm.grpc.analyzetext.{AnalyzeResponse, TextRequest}

import java.util.logging.Logger
import scala.concurrent.Future

class AnalyzeTextService extends AnalyzeText {
  private val logger = Logger.getLogger(classOf[AnalyzeTextService].getName)

  override def analyzeText(request: TextRequest): Future[AnalyzeResponse] = {
    val responseStr = s"Original text: ${request.message}, text length: ${request.message.length}"
    logger.info(responseStr)
    val response = AnalyzeResponse(responseStr)
    Future.successful(response)
  }

}
