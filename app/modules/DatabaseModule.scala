package modules

import com.google.inject.Provider
import com.typesafe.config.ConfigFactory
import pl.edu.agh.iet.akka_tracing.config.ConfigurationReader
import pl.edu.agh.iet.akka_tracing.visualization.data.DataSource
import play.api.inject.{ Binding, Module }
import play.api.{ Configuration, Environment }

class DataSourceProvider extends Provider[DataSource] {

  import play.api.libs.concurrent.Execution.Implicits.defaultContext

  override def get(): DataSource = {
    val config = ConfigFactory.load("akka_tracing.conf")
    val configReader = new ConfigurationReader(config, getClass.getClassLoader)
    configReader.getDataSource
  }
}

class DatabaseModule extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = {
    Seq(bind[DataSource].toProvider[DataSourceProvider])
  }
}
