package eu.luminis.workshop.smallsteps.logic

import java.util.*

interface UserDAO {
  suspend fun insertUser(email: String, password: String): UUID
}
