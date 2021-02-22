package config

import java.util.Base64
import scala.util.Properties

object Configuration {

  val baseURL: String = "http://azure-qknows-prod-challenges-1.northeurope.cloudapp.azure.com"
  val get_all_persons: String = "/api/person/all"

  private val qUser = sys.env.getOrElse("QKNOWS_BACKEND_USER", "")
  private val qPassw = sys.env.getOrElse("QKNOWS_BACKEND_PASSWORD", "")
  private val plainCreds = qUser.concat(":").concat(qPassw)
  private val plainCredsBytes = plainCreds.getBytes
  private val base64CredsBytes = Base64.getEncoder.encode(plainCredsBytes)
  val base64Creds = new String(base64CredsBytes)
}
