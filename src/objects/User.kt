package objects

import classes.User

object UserManager {
    private var user: User? = null

    fun createUser(): User {
        print("First name: ")
        val firstName = readln()
        println("Email: ")
        val email = readln()
        println("Password: ")
        val password = readln()
        println("Projects: ")
        return User(firstName, email, password, projects = "list")
    }

    fun getUser(): User? = user
}

class UserController {
    fun createUser() {
        UserManager.createUser()
    }

    fun displayUser() {
        val user = UserManager.getUser()
        user?.let {
            println("User Info: ")
            println("First Name: ${it.firstName}")
            println("Email: ${it.email}")
            println("Projects: ${it.projects}")
        }
    }
}
