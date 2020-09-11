package dd.oliver.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RegisterController : HttpServlet() {
    override fun doPost(req: HttpServletRequest, res: HttpServletResponse) {
        val name: String = req.getParameter("username")
        val password: String = req.getParameter("password")
        println("username is $name")
        println("password is $password")
        res.writer.write("Hello, $name ! Now is ${req.contextPath}")
    }
}