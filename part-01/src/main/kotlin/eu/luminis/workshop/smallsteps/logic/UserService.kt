package eu.luminis.workshop.smallsteps.logic

import eu.luminis.workshop.smallsteps.persistence.UserDAOImpl

// Understands how users can be registered
class UserService(private val userPersistence: UserDAO) {
    suspend fun registerNewUser(command: NewUserCommand) {
        userPersistence.insertUser(command.email.value, command.password.value)
    }
}

data class NewUserCommand(
    val email: Email,
    val password: Password,
)

data class Email(
    val email: String
) {
    val value: String
    init {
        require(email.isNotBlank()) { "Please enter an email address" }
        value = email
    }
}
data class Password(
    val password: String
) {
    val value: String
    init {
        require(password.isNotBlank() && password.length >= 8) { "Password must be at least 8 characters long" }
        value = password
    }
}