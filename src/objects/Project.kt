package objects

import classes.Project

object ProjectManager {
    private var project: Project? = null

    fun createProject(): Project {
        println("Name: ")
        val name = readln()
        return Project(name, participants = "me")
    }

    fun getProject(): Project? = project
}

class ProjectController {
    fun createProject() {
        ProjectManager.createProject()
    }

    fun displayProject() {
        val project = ProjectManager.getProject()
        project?.let {
            println({ it.name })
            println({ it.participants })
        }
    }
}
