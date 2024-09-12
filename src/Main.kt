import objects.CommentController
import objects.ProjectController
import objects.TaskController
import objects.UserController
import kotlin.system.exitProcess

fun main() {
    val userController = UserController()
    val commentController = CommentController()
    val taskController = TaskController()
    val projectController = ProjectController()
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
            "1" -> userController.createUser()
            "2" -> userController.displayUser()
            "3" -> commentController.createComment()
            "4" -> commentController.displayComment()
            "5" -> taskController.createTask()
            "6" -> taskController.displayTask()
            "7" -> projectController.createProject()
            "8" -> projectController.displayProject()
            "9" -> exitProcess(0)
            else -> println()
        }
    }
}
