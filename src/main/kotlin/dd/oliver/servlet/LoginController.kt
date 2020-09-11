package dd.oliver.servlet

import dd.oliver.servlet.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class LoginController : HttpServlet() {
    override fun doPost(req: HttpServletRequest, res: HttpServletResponse) {
        val inputStream = BufferedReader(InputStreamReader(req.inputStream, "UTF-8"))
        val inputStrBuilder = StringBuilder()
        var inputStr: String
        while (inputStream.readLine().also { inputStr = it } != null)
            inputStrBuilder.append(inputStr)
        val user = Json.decodeFromString<User>(inputStrBuilder.toString())
        res.writer.write("Hello, ${user.username} ! Now is ${req.contextPath}")
    }
}