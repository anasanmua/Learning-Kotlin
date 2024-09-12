package objects

import classes.Project
import classes.Task
import classes.User
import enumerators.Priority
import enumerators.State
import enumerators.Type
import java.time.LocalDateTime

object TaskManager {
    private var task: Task? = null

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

    fun getTask(): Task? = task
}

class TaskController {
    fun createTask() {
        TaskManager.createTask()
    }

    fun displayTask() {
        val task = TaskManager.getTask()
    }
}
