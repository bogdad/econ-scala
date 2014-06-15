package ru.econ.internal

import org.springframework.context.annotation.{AnnotationConfigApplicationContext, Bean, ImportResource, Configuration}
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean
import org.springframework.web.client.RestTemplate
import com.coherentlogic.fred.client.db.integration.dao.{SeriessDAO, ObservationsDAO}
import com.coherentlogic.fred.client.core.builders.QueryBuilder
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.ApplicationContext
import javax.persistence.{EntityManagerFactory, Persistence, EntityManager}

/**
 * Created by vshakhov on 14.06.14.
 */
@Configuration
class SpringConfig {
  @Bean
  def points(queryBuilder: QueryBuilder,
             observationsDao: ObservationsDAO): Points = {
    new Points(queryBuilder, observationsDao)
  }
  @Bean
  def econBuilder(restTemplate: RestTemplate): QueryBuilder = EconQueryBuilder(restTemplate)

  @Bean
  def seriesDao() = new SeriessDAO()

  @Bean
  def observationsDao(): ObservationsDAO = new ObservationsDAO

  @Bean
  def entityManagerFactory(): LocalEntityManagerFactoryBean = new LocalEntityManagerFactoryBean
}

object SpringConfig {
  def apply(): ApplicationContext = {
    new ClassPathXmlApplicationContext("/application-context.xml")
  }
}