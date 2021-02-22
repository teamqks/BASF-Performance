package requests

import config.Configuration.{base64Creds, baseURL, get_all_persons}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetAllPersonsRequest{

  var get_all: HttpRequestBuilder = http("Get All Persons")
    .get(baseURL + get_all_persons)
    .header("accept", "*/*")
    .header("Authorization", "Basic " + base64Creds)
    .check(status is 200)
    .check(regex("\"firstName\":\"(.*?)\""))
}