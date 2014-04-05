package ru.econ

import scala.collection.JavaConversions._
import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.core.builders.QueryBuilder
import com.coherentlogic.fred.client.core.domain._
import javax.inject.{Named, Inject}

/**
 * Created by vshakhov on 02.04.14.
 */
class Calc(@Inject val restTemplate:RestTemplate) {

  def calc() {
    val builder = new QueryBuilder(restTemplate, "http://api.stlouisfed.org/fred")

    val seriess = builder
      .series ()
      .search ()
      .setApiKey("e1a53756f5fe7f4c24f85af57f6bae45")
      .setSearchText("1-Month London Interbank Offered Rate")
      .setSearchType(SearchType.fullText)
      //      .setRealtimeStart(realtimeStart)
      //      .setRealtimeEnd(realtimeEnd)
      .setLimit(1000)
      .setOffset(1)
      .setOrderBy(OrderBy.searchRank)
      .setSortOrder(SortOrder.desc)
      .setFilterVariable(FilterVariable.frequency)
      .setFilterValue(FilterValue.all)
      .doGet(classOf[Seriess])

    val list = seriess.getSeriesList()
    list.foreach((x : Series) => x.getTitle)
  }
}
