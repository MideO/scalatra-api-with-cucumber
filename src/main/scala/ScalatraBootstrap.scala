import com.github.mideo.app._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger: CalculatorSwagger = new CalculatorSwagger

  override def init(context: ServletContext) {
    context.initParameters("org.scalatra.cors.allowedOrigins") = "*"
    context.mount(new CalculatorServlet, "/")
    context.mount (new ResourcesApp, "/api-docs")

  }
}
