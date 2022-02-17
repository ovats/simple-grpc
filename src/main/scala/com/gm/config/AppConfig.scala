package com.gm.config

import pureconfig._
import pureconfig.generic.auto._

import java.util.logging.Logger

final case class GrpcClient(host: String, port: Int)
final case class GrpcServer(port: Int)
final case class Grpc(client: GrpcClient, server: GrpcServer)
final case class AppConfig(grpc: Grpc)

object AppConfig {
  private val logger = Logger.getLogger(classOf[AppConfig].getName)

  def apply(resource: String = "application.conf"): AppConfig = {
    ConfigSource.resources(resource).load[AppConfig] match {
      case Left(errors) =>
        val msg = s"Unable to load service configuration (AppConfig)"
        logger.info(s"$msg \n${errors.toList.map(_.description).mkString("* ", "\n*", "")}")
        throw new IllegalStateException(msg)

      case Right(config) =>
        logger.info(s"Successfully loaded configuration (AppConfig), $config")
        config
    }
  }

}
