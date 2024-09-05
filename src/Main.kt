import java.time.LocalDateTime
import kotlin.system.exitProcess

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val users: MutableList<User> = arrayListOf()
    println(users)
    val comments: MutableList<Comment> = arrayListOf()
    val tasks: MutableList<Task> = arrayListOf()
    val projects: MutableList<Project> = arrayListOf()
    while (true) {
        println(
            "Selecciona una opción:\n" +
                "1.Crear usuario\n" +
                "2.Listar usuarios\n" +
                "3.Crear comentario\n" +
                "4.Listar comentarios\n" +
                "5.Crear tarea\n" +
                "6.Listar tareas\n" +
                "7.Crear proyecto\n" +
                "8.Listar proyectos\n" +
                "9.Salir\n" +
                ">>>>",
        )
        val response = readln()
        when (response) {
            "1" -> users.add(User.createUser())
            "2" -> users.map { println(it.firstName + ", " + it.email + ", " + it.password + ", " + it.projects) }
            "3" -> comments.add(Comment.createComment())
            "4" -> comments.map { println(it.createdBy + ", " + it.createdOn + ", " + it.description) }
            "5" -> tasks.add(Task.createTask())
            "6" ->
                tasks.map {
                    println(
                        it.description + ", " + it.type + ", " + it.sprint + ", " + it.title + ", " + it.state + ", " + it.priority + ", " +
                            it.project +
                            ", " +
                            it.createdBy +
                            ", " +
                            it.assignedTo +
                            ", " +
                            it.createdOn +
                            ", " +
                            it.modifiedOn +
                            ", " +
                            it.comments,
                    )
                }
            "7" -> projects.add(Project.createProject())
            "8" -> projects.map { println(it.name + ", " + it.participants) }
            "9" -> exitProcess(0)
            else -> println()
        }
    }
}

class User(
    var firstName: String,
    val email: String,
    val password: String,
    val projects: String, // List of projects
) {
    companion object {
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
    }
}

class Comment(
    var createdBy: String, // Change to User
    var description: String,
    var createdOn: String,
) {
    companion object {
        fun createComment(): Comment {
            println("created by:")
            val createdBy = readln()
            println("description:")
            val description = readln()
            println("created on:")
            val createdOn = readln()
            return Comment(createdBy, description, createdOn)
        }
    }
}

class Task(
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
) {
    companion object {
        fun createTask(): Task {
            val projects: MutableList<Project> = arrayListOf()
            println("Select State: ")
            State.values().forEachIndexed { index, state ->
                println("${index + 1}. $state")
            }
            val stateIndex = readln().toInt() - 1
            val state = State.values()[stateIndex]

            println("Description:")
            val description = readln()

            println("Title:")
            val title = readln()

            println("Select a priority: ")
            Priority.values().forEachIndexed { index, priority ->
                println("${index + 1}. $priority")
            }
            val priorityIndex = readln().toInt() - 1
            val priority = Priority.values()[priorityIndex]

            val createdBy = User("Creator", "Creator", "Creator", "Creator")
            val assignedTo = User("Assignee", "Assignee", "Assignee", "Assignee")
            val createdOn = LocalDateTime.now()
            val modifiedOn = LocalDateTime.now()

            println("Select a type")
            Type.values().forEachIndexed { index, type ->
                println("${index + 1}. $type")
            }
            val typeIndex = readln().toInt() - 1
            val type = Type.values()[typeIndex]

            val comments = "Example list"

            println("Type in which to which sprint this task belongs ")
            val sprint = readln()
            println("Select project")
            projects.forEachIndexed { index, project ->
                println("${index + 1}. ${project.name}")
            }
            val project = Project("Sample Project", "Sample Project")

            return Task(
                state,
                description,
                title,
                priority,
                createdBy,
                assignedTo,
                createdOn,
                modifiedOn,
                type,
                comments,
                sprint,
                project,
            )
        }
    }
}

class Project(
    var name: String,
    var participants: String, // List of Users
) {
    companion object {
        fun createProject(): Project {
            println("Name: ")
            val name = readln()
            return Project(name, participants = "me")
        }
    }
}

enum class Priority {
    P1,
    P2,
    P3,
    P4,
}

enum class Type {
    TASK,
    BUG,
}

enum class State {
    READY,
    IN_PROGRESS,
    BLOCKED,
    DONE,
}
