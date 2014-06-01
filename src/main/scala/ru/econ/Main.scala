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
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.h2.tools.Server

/**
 * Created by vshakhov on 02.03.14.
 */
object Main {

  def main(args: Array[String]) {
    // start the TCP Server
    val server = Server.createTcpServer().start

    val applicationContext = new ClassPathXmlApplicationContext("/application-context.xml")
    val restTemplate = applicationContext.getBean("fredRestTemplate", classOf[RestTemplate])
    val calc = new Calc(restTemplate)

    calc.calc

    server.stop
  }

}
