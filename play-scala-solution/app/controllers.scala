package controllers

import play.mvc._
import results._
import play.db.anorm._
import defaults._

object Application extends Controller {

  def index = Template

  def hello(name: String = "Guest") = Template('username -> name)

  def helloOption(name: Option[String]) = {
    Template('username -> name.getOrElse("Guest"))
  }

  def helloXml(name: String = "Guest") = Xml(<message>Hello ${ name }!</message>)

  def helloHtml(name: String = "Guest") = Html("<h1><em>Hello " + name + " !</em></h1>")

  def response(name: String = "Guest") = {
    //Created
    //Forbidden
    //BadRequest
    //NotFound
    Error("Sorry dude ;-)")
  }

  case class SmallCountry(name: String)
  case class BigCountry(name: String)
  case class France

  case class Country(code: Id[String], name: String, population: Int, headOfState: Option[String])
  case class City(id: Pk[Int], name: String)
  case class CountryLanguage(language: String, isOfficial: String)

  def sql() = {
	// Select 1
    var result: Boolean = SQL("Select 1").execute()
    
    // Update / Delete
    var updateDB = SQL("delete from City where id = 99").executeUpdate().fold(
      e => println("Oops, there was an error"),
      c => println(c + " rows were updated!"))
      
    // Count
    val firstRow = SQL("select count(*) as c from Country").apply().head
    val countryCount = firstRow[Long]("c")

    // Transform the resulting Stream[Row] as a List[(String,String)]
    val selectCountries = SQL("select * from Country")
    val countries = selectCountries().map(row => row[String]("code") -> row[String]("name")).toList
    
    // Multiline string, params (on and onParams)
    val query = SQL(
      """
        select * from Country c 
        join CountryLanguage l on l.CountryCode = c.Code 
        where c.code = 'FRA';
	  """)
    val queryWithParam = SQL(
      """
        select * from Country c 
        join CountryLanguage l on l.CountryCode = c.Code 
        where c.code = {countryCode};
      """).on("countryCode" -> "FRA")
    val queryOnParam = SQL(
      """
        select * from Country c 
        join CountryLanguage l on l.CountryCode = c.Code 
        where c.code = {countryCode};
      """).onParams("FRA")
    
    // Pattern matching (collect)
    val dispatch = SQL("Select name,population from Country")().collect {
      case Row("France", _) => France()
      case Row(name: String, pop: Int) if (pop > 1000000) => BigCountry(name)
      case Row(name: String, _) => SmallCountry(name)
    }
  
    // Magic
    val count = Country.count().single()
    val countParam = Country.count("population > 1000000").single()
    val list = Country.find().list()
    val listParam = Country.find("population > 1000000").list()
    val complex = Country.find("code = {c}").on("c" -> "FRA").first()
    
    // Template
    Template('count -> countryCount, 'countries -> countries, 'dispatch -> dispatch, 'listParam -> listParam, 'complex -> complex)
  }
  
  object Country extends Magic[Country]
  object CountryLanguage extends Magic[CountryLanguage]
  object City extends Magic[City]

}
