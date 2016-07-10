package $organization$.resources

import akka.actor.ActorSystem
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

class PingResource()(implicit system: ActorSystem, executor: ExecutionContextExecutor, materializer: ActorMaterializer) {

  val routes =
    path("ping") {
      complete("pong")
    }

}
