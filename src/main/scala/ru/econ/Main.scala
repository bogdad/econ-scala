package ru.econ

import com.coherentlogic.fred.client.core.builders.QueryBuilder
import com.coherentlogic.fred.client.core.domain.Seriess
import org.springframework.web.client.RestTemplate

/**
 * Created by vshakhov on 02.03.14.
 */
object Main {

  def main(args: Array[String]) {
    println("hello world")
  }

  def test1() {
    val restTemplate = new RestTemplate()
    val builder = new QueryBuilder(restTemplate, "http://api.stlouisfed.org/fred")

    val seriess = builder
      .series ()
      .search ()
      .setApiKey("e1a53756f5fe7f4c24f85af57f6bae45")
      .setSearchText("money stock")
      .setSearchType(SearchType.fullText)
      .setRealtimeStart(realtimeStart)
      .setRealtimeEnd(realtimeEnd)
      .setLimit(1000)
      .setOffset(1)
      .setOrderBy(OrderBy.searchRank)
      .setSortOrder(SortOrder.desc)
      .setFilterVariable(FilterVariable.frequency)
      .setFilterValue(FilterValue.all)
      .doGet(classOf(Seriess));
  }

}
