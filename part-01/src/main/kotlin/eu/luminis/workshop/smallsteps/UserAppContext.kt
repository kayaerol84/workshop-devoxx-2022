package eu.luminis.workshop.smallsteps

import eu.luminis.workshop.smallsteps.logic.UserService
import eu.luminis.workshop.smallsteps.persistence.DatabaseFactory
import eu.luminis.workshop.smallsteps.persistence.UserDAOImpl

// Understands how to wire up the various components in the system
internal class UserAppContext {
    init {
        DatabaseFactory.connectAndMigrate()
    }

    private val userDAO = UserDAOImpl()

    val userService = UserService(userDAO)
}