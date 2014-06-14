package ru.econ.internal

import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.core.builders.QueryBuilder

/**
 * Created by vshakhov on 14.06.14.
 */
class EconQueryBuilder(val restTemplate: RestTemplate) extends QueryBuilder(restTemplate, "http://api.stlouisfed.org/fred") {

}

object EconQueryBuilder {
  def apply(restTemplate: RestTemplate) = {
    new EconQueryBuilder(restTemplate)
      .setApiKey("e1a53756f5fe7f4c24f85af57f6bae45")
  }
}