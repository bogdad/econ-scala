
import scala.collection.JavaConversions._
import com.coherentlogic.fred.client.core.domain.{Series, Seriess}
import org.h2.tools.Server
import org.scalatest.junit.AssertionsForJUnit
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.web.client.RestTemplate
import ru.econ.internal.{SpringConfig, Points, EconQueryBuilder}
import org.junit._

class SearchTest extends AssertionsForJUnit {

  val server = Server.createTcpServer().start()
  val applicationContext = SpringConfig()
  val restTemplate = applicationContext.getBean("fredRestTemplate", classOf[RestTemplate])
  val points: Points = applicationContext.getBean(classOf[Points])
  val queryBuilder = applicationContext.getBean(classOf[EconQueryBuilder])

  @Before def initialize() {

  }

  @After def shutdown() {
    //server.stop()
  }

  @Test def verifyTotalEmployed() {
    val obs = points.get("PAYEMS")
    points.save(obs)
  }

  @Test def verifyMonetaryIndexServices() {
    val seriess = queryBuilder
      .series ()
      .search ()
      .setSearchText("monetary service index")
      .doGet(classOf[Seriess])
    val list = seriess.getSeriesList()
    System.out.println(if (seriess.getCount > 0) {
      System.out.print(seriess.getCount)
      list.foreach((x: Series) => System.out.println(x.getTitle))
    })
  }
}
