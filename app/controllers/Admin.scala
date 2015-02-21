package controllers

import models.{User, Credentials}
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints
import play.api.mvc._
import play.mvc.Security.Authenticated

/**
 * Created by sokzzuka on 21.02.15.
 */
object Admin extends Controller {

  val loginForm: Form[Credentials] = Form(mapping(
    "username" -> text.verifying(Constraints.nonEmpty),
    "password" -> text.verifying(Constraints.minLength(6))
  )(Credentials.apply)(Credentials.unapply))

  def authenticatedSession(username: String): Session =
    Session(Map("username" -> username))

  def submitLogin = Action { implicit request =>
    val filledForm = loginForm.bindFromRequest()

    filledForm.fold(
      (errorForm: Form[Credentials]) => {
        Ok(views.html.login(errorForm))
      },
      (credentials: Credentials) => {
        credentials match {
          case Credentials(username, password) =>
//            User.authenticate(username, password)match {
//              case Some(user) => ???
//              case None => ???
//            }

            User.authenticate(username, password) map { user =>
              Redirect(routes.Application.index).withSession(Security.username -> username)
            } getOrElse {
              Ok(views.html.login(filledForm.withGlobalError("Username or password incorrect")))
            }
        }
      }
    )
  }

  def index = Action {
    Ok(views.html.login(loginForm))
  }

}
