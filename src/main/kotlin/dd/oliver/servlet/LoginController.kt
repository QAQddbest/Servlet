package dd.oliver.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class LoginController : HttpServlet() {
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val name: String = req.getParameter("username")
        val password: String = req.getParameter("password")
        println("用户名$name")
        println("密码$password")

    }
}