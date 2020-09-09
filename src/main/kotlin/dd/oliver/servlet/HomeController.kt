package dd.oliver.servlet

import java.util.*
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HomeController : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        val date: Date = Date()
        res.writer.write("Hello, World! Now is ${date.time}")
    }
}