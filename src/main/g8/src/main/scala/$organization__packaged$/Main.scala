package hlouw.dcos.service.rest

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import $organization$.resources.PingResource

object Main extends App {

  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val config = ConfigFactory.load()

  val pingResource = new PingResource()

  val routes = pingResource.routes

  Http().bindAndHandle(routes, config.getString("http.interface"), config.getInt("http.port"))
}
