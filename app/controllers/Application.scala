package controllers

import play.api.mvc.{InjectedController}

class Application extends InjectedController {

  def index = Action {
    Ok(views.html.index())
  }

}
