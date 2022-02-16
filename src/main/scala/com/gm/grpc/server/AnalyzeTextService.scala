package com.gm.grpc.server

import com.gm.grpc.analyzetext.AnalyzeTextGrpc.AnalyzeText
import com.gm.grpc.analyzetext.{AnalyzeResponse, TextRequest}

import scala.concurrent.Future

class AnalyzeTextService extends AnalyzeText {

  override def analyzeText(request: TextRequest): Future[AnalyzeResponse] = {
    val responseStr = s"Original text: ${request.message}, text length: ${request.message.length}"
    val response    = AnalyzeResponse(responseStr)
    Future.successful(response)
  }

}
