package performancetests

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class EnduranceTest extends Simulation{

  val httpProtocol: HttpProtocolBuilder = http.baseUrl("https://api.publicapis.org")
    .header("Accept", "application/json")

  val scn: ScenarioBuilder = scenario("getALL")
    .exec(
      http("getALL")
        .get("/")
    )

//  Setup is define for 8 hours endurance test
  setUp(scn.inject(
    //    rampUsers(500) during(30000)
    //    constantConcurrentUsers(5) during(30000)
        constantUsersPerSec(5) during(30000)
      ).protocols(httpProtocol)
  )
    // Assertion to validate
    // 1. Maximum response time is less than 100 ms
    // 2. Number of successful requests is greater than 95%
    .assertions(
      global.responseTime.max.lt(1100),
      global.successfulRequests.percent.gt(95)
    )

}

