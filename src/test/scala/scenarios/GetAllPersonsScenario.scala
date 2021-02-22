package scenarios

import requests.GetAllPersonsRequest
import io.gatling.core.Predef.scenario
import io.gatling.core.structure.ScenarioBuilder

object GetAllPersonsScenario {
  val getAllPersons: ScenarioBuilder = scenario("Get All Persons")
    .exec(GetAllPersonsRequest.get_all)
}