package ru.econ.internal

import com.coherentlogic.fred.client.core.domain.{Observations, Series}
import javax.inject.Inject
import com.coherentlogic.fred.client.db.integration.dao.ObservationsDAO
import org.springframework.context.annotation.Bean
import com.coherentlogic.fred.client.core.builders.QueryBuilder

/**
 * Created by vshakhov on 14.06.14.
 */
@Bean
class Points(@Inject val queryBuilder: QueryBuilder, @Inject val observationsDao: ObservationsDAO) {
    def get(series : String):Observations = {
      return queryBuilder
        .series()
        .observations()
        .setSeriesId(series)
        .doGet(classOf[Observations])
    }

    def save(observations: Observations) {
      observationsDao.persist(observations)
    }
}
