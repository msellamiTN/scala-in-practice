package controllers

import play.mvc._

/**
 * http://scala.playframework.org/documentation/scala-0.9/dataBinding
 */
object Application extends Controller {
    
    def index = Template
    
    def hello(name: String = "Guest") = {
   	 "Hello " + name + " !"
    }
    
}
