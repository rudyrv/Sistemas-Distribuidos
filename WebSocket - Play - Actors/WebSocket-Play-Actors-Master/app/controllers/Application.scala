package controllers

import scala.Left
import scala.Right
import scala.concurrent.Future
import scala.util.Random
import actors.UserActor
import play.api.Logger
import play.api.Play.current
import play.api.libs.json.JsValue
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.WebSocket

object Application extends Controller {
  val UID = "uid"
  var counter = 0

  /*
  * El método index, se ejecuta automáticamente al cargar localhost:9000.
  * <Checar en Routes>
  * GET     /    controllers.Application.index
  */
  def index = Action { implicit request => {
  val uid: String = request.session.get(UID).getOrElse {
    counter += 1
    counter.toString
  }
  Ok(views.html.index(uid)).withSession {
    Logger.debug("Se creó un UID: " + uid) //Esto se muestra en la terminal de Play.
    request.session + (UID -> uid) //Asignamos el valor de uid a UID.
  }
  }}



/*
* Método WebSocket, el método implementa un websocket que recibe dos valores,
* en caso de que la petición (En algún momento futuro) sea exitosa, se solicita el Id
* único de la sesión del usuario, en caso que no exista un ID, el servicio se prohíbe.
* En caso que el ID exista se llama al método UserActor.props definido dentro de la carpeta
* actores.
*/
  def ws = WebSocket.tryAcceptWithActor[JsValue, JsValue] { implicit request =>
    Future.successful(request.session.get(UID) match {
      case None => Left(Forbidden)
      case Some(uid) => Right(UserActor.props(uid))
    })
  }

}
