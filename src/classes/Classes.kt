package classes

import enumerators.Priority
import enumerators.State
import enumerators.Type
import java.time.LocalDateTime

data class User(
    var firstName: String,
    val email: String,
    val password: String,
    val projects: String, // List of projects
)

data class Comment(
    var createdBy: String, // Change to User
    var description: String,
    var createdOn: String,
)

data class Task(
    var state: State,
    var description: String,
    var title: String,
    var priority: Priority,
    var createdBy: User,
    var assignedTo: User,
    var createdOn: LocalDateTime,
    var modifiedOn: LocalDateTime,
    var type: Type,
    var comments: String, // List of comments
    var sprint: String,
    var project: Project,
)

data class Project(
    var name: String,
    var participants: String, // List of Users
)
