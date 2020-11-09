package sdu

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class DemoSimulation extends Simulation {

  val httpConf: HttpProtocolBuilder = http
    .baseUrl(URL)
    //    .acceptHeader("text/json,application/json;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")
  val scn: ScenarioBuilder = scenario("loadtest")
    .exec(MyTest.simpletest)

  def URL: String = System.getProperty("URL")

  def users: Double = Integer.getInteger("users", 5).doubleValue()

  def period: Integer = Integer.getInteger("seconds", 10)

  object MyTest {
    val simpletest: ChainBuilder = exec(http("loadtest")
      .get("/")
      .check(status.is(200))
    )
  }

  setUp(
    scn.inject(
      constantUsersPerSec(users) during (period seconds) randomized
      //rampUsersPerSec(1) to users during(period seconds)
    )
  ).protocols(httpConf)

}