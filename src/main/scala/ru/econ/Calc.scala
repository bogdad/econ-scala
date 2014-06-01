package ru.econ

import scala.collection.JavaConversions._
import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.core.builders.QueryBuilder
import com.coherentlogic.fred.client.core.domain._
import javax.inject.{Named, Inject}
import org.joda.time.{Duration, Instant}

/**
 * Created by vshakhov on 02.04.14.
 */
class Calc(@Inject val restTemplate:RestTemplate) {

  def calc() {
    val builder = new QueryBuilder(restTemplate, "http://api.stlouisfed.org/fred")

    var start = new Instant()

    val seriess = builder
      .series ()
      .search ()
      .setApiKey("e1a53756f5fe7f4c24f85af57f6bae45")
      .setSearchText("monetary service index")
      //.setSearchType(SearchType.fullText)
      //.setRealtimeStart(start.minus(Duration.standardDays(300)).toDate)
      //.setRealtimeEnd(Instant.now.toDate)
      //.setLimit(1000)
      //.setOffset(0)
      //.setOrderBy(OrderBy.searchRank)
      //.setSortOrder(SortOrder.desc)
      //.setFilterVariable(FilterVariable.frequency)
      //.setFilterValue(FilterValue.all)
      .doGet(classOf[Seriess])

    val list = seriess.getSeriesList()
    if (seriess.getCount > 0) {
      System.out.print(seriess.getCount)
      list.foreach((x: Series) => x.getTitle)
    }
  }
}
