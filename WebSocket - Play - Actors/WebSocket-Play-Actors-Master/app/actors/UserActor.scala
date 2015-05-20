package actors

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.event.LoggingReceive
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import akka.actor.ActorRef
import akka.actor.Props
import scala.xml.Utility
import java.util.Calendar
import java.text.SimpleDateFormat

/*
* Esta clase define un actor.
* UserActor funciona como una puerta de enlace entre los actores conectados al "board" y el websocket.
* Este actor envía mensajes a BoardActor.scala
*/
class UserActor(uid: String, board: ActorRef, out: ActorRef) extends Actor with ActorLogging {

  /*
  * Antes que otra cosa, el actor se suscribe a BoardActor
  */
  override def preStart() = {
    BoardActor() ! Subscribe
  }

  /*
  * Se obtiene el tiempo de la instancia, se extraé el formato en la variable val
  * para finalmente agregar el tiempo en el archivo JSON (val js)
  */
  val today = Calendar.getInstance().getTime()

  val hour  = new SimpleDateFormat("hh").format(today)
  val ampm  = new SimpleDateFormat("a").format(today)
  val minute  = new SimpleDateFormat("mm").format(today)
  val seconds = new SimpleDateFormat("s").format(today)
  val miliseconds = new SimpleDateFormat("S").format(today)

  val time = hour + ":" + minute + ":" + seconds + ":" + miliseconds + " " + ampm

  /*
  * Los actores reciben mensajes
  * Cuando este actor recibe un mensaje, se crea un JSON.
  */
  def receive = LoggingReceive {
    case Message(muid, s) if sender == board => {
      val js = Json.obj("type" -> "message", "uid" -> muid, "msg" -> s, "timestamp" -> time)
      out ! js
    }
    case js: JsValue => (js \ "msg").validate[String] map { Utility.escape(_) }  map { board ! Message(uid, _ ) }
    case other => log.error("Error, no se creó el objeto JSON: " + other)
  }
}
/*
* Definición del objeto UserActor
* Recibe el id y envía a BoardActor
*/
object UserActor {
  def props(uid: String)(out: ActorRef) = Props(new UserActor(uid, BoardActor(), out))
}
