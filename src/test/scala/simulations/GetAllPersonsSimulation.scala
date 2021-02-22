package simulations

import scenarios.GetAllPersonsScenario
import io.gatling.core.Predef._
import scala.concurrent.duration._

class GetAllPersonsSimulation extends Simulation {

  private val getAllPersonsExec = GetAllPersonsScenario.getAllPersons
    .inject(constantUsersPerSec(1200).during(Duration(40, MINUTES)))
    .throttle(
      reachRps(300).in(Duration(10, MINUTES)),
      holdFor(Duration(30, MINUTES)
      )
  )

  setUp(getAllPersonsExec)
    .assertions(global.failedRequests.percent.lt(5.0))

}
