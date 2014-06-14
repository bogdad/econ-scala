package ru.econ.internal

import org.springframework.context.annotation.{AnnotationConfigApplicationContext, Bean, ImportResource, Configuration}
import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.db.integration.dao.ObservationsDAO
import com.coherentlogic.fred.client.core.builders.QueryBuilder

/**
 * Created by vshakhov on 14.06.14.
 */
@Configuration
@ImportResource(Array("classpath:/application-context.xml", "classpath:/hibernate-beans.xml"))
class SpringConfig {
  @Bean
  def points(queryBuilder: QueryBuilder,
             observationsDao: ObservationsDAO): Points = {
    new Points(queryBuilder, observationsDao)
  }
  @Bean
  def econBuilder(restTemplate: RestTemplate): QueryBuilder = {
    EconQueryBuilder(restTemplate)
  }
}

object SpringConfig {
  def apply(): AnnotationConfigApplicationContext = {
    new AnnotationConfigApplicationContext(classOf[SpringConfig])
  }
}