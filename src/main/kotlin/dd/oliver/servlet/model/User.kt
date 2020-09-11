package dd.oliver.servlet.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
)