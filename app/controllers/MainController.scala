package controllers

import com.google.inject.Inject
import org.json4s.DefaultFormats
import org.json4s.ext.JavaTypesSerializers
import org.json4s.native.Serialization._
import pl.edu.agh.iet.akka_tracing.visualization.data.DataSource
import play.api.mvc._

class MainController @Inject() (dataSource: DataSource) extends Controller {

  import play.api.libs.concurrent.Execution.Implicits.defaultContext

  private implicit val formats = DefaultFormats ++ JavaTypesSerializers.all

  def index: Action[AnyContent] = Action.async {
    val messagesListFuture = dataSource.getMessages
    val relationListFuture = dataSource.getRelations

    for {
      messagesList <- messagesListFuture
      relationList <- relationListFuture
    } yield Ok(views.html.index(messagesList.map(write(_)))(relationList.map(write(_))))
  }
}
