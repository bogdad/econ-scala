package ru.econ

import scala.collection.JavaConversions._
import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.core.builders.QueryBuilder
import com.coherentlogic.fred.client.core.domain._
import javax.inject.{Named, Inject}
import org.joda.time.{Duration, Instant}
import ru.econ.internal.EconQueryBuilder

/**
 * Created by vshakhov on 02.04.14.
 */
class Calc(val restTemplate: RestTemplate) {

  def calc() {

    val seriess = EconQueryBuilder(restTemplate)
      .series ()
      .search ()
      .setSearchText("monetary service index")
      .doGet(classOf[Seriess])

    val list = seriess.getSeriesList()
    if (seriess.getCount > 0) {
      System.out.print(seriess.getCount)
      list.foreach((x: Series) => x.getTitle)
    }
  }
}
