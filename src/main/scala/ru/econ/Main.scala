package ru.econ

import scala.collection.JavaConversions._


import com.coherentlogic.fred.client.core.builders.QueryBuilder
import com.coherentlogic.fred.client.core.domain._
import org.springframework.web.client.RestTemplate
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter
import org.springframework.oxm.xstream.XStreamMarshaller
import com.thoughtworks.xstream.io.xml.{XmlFriendlyReplacer, XppDriver}
import com.coherentlogic.fred.client.core.converters.{SortOrderEnumConverter, OutputTypeEnumConverter, ApplicationZipMessageConverter}
import com.thoughtworks.xstream.converters.basic.DateConverter

/**
 * Created by vshakhov on 02.03.14.
 */
object Main {

  def main(args: Array[String]) {
    println("hello world")
    test1()
  }

  def test1() {
    val restTemplate = new RestTemplate()
    val xppDriver = new XppDriver(new XmlFriendlyReplacer("_-","-"))
    val streamMarshaller = new XStreamMarshaller
    streamMarshaller.setStreamDriver(xppDriver)
    streamMarshaller.setAutodetectAnnotations(true)
    streamMarshaller.setAnnotatedClasses(Array(
      classOf[Seriess],
      classOf[Source],
      classOf[Sources],
      classOf[Series],
      classOf[Categories],
      classOf[Category],
      classOf[Observations],
      classOf[Observation],
      classOf[Releases],
      classOf[Release],
      classOf[VintageDates],
      classOf[VintageDate],
      classOf[ReleaseDates],
      classOf[ReleaseDate]
    ))
    val converter = new MarshallingHttpMessageConverter
    converter.setMarshaller(streamMarshaller)
    converter.setUnmarshaller(streamMarshaller)
    val applicationZipConverter = new ApplicationZipMessageConverter

    val dateConverter = new DateConverter("yyyy-MM-dd", Array("yyyy-MM-dd"))
    val outputTypeConverter = new OutputTypeEnumConverter(classOf[OutputType])
    val sortOrderTypeConverter = new SortOrderEnumConverter(classOf[SortOrder])
    val messageConverters = List(converter, applicationZipConverter)
    val httpConverter = new MarshallingHttpMessageConverter()

    restTemplate.setMessageConverters(messageConverters)
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

    seriess.getSeriesList.foreach((x : Series) => x.getTitle)

  }

}
