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
            """
            Selecciona una opción:
            1. Gestionar usuarios
            2. Gestionar proyectos
            3. Salir
            >>>>
            """.trimIndent(),
        )
        when (readln()) {
            "1" -> gestionarUsuarios(userController, commentController, taskController)
            "2" -> gestionarProyectos(projectController)
            "3" -> exitProcess(0)
            else -> println("Opción inválida, por favor intenta de nuevo.")
        }
    }
}

fun gestionarUsuarios(
    userController: UserController,
    commentController: CommentController,
    taskController: TaskController,
) {
    while (true) {
        println(
            """
            Gestión de Usuarios:
            1. Crear usuario
            2. Listar usuarios
            3. Crear comentario
            4. Listar comentarios
            5. Crear tarea
            6. Listar tareas
            7. Volver al menú principal
            >>>>
            """.trimIndent(),
        )
        when (readln()) {
            "1" -> userController.createUser()
            "2" -> userController.displayUser()
            "3" -> commentController.createComment()
            "4" -> commentController.displayComment()
            "5" -> taskController.createTask()
            "6" -> taskController.displayTask()
            "7" -> return // Goes back to the main menu
            else -> println("Opción inválida, por favor intenta de nuevo.")
        }
    }
}

fun gestionarProyectos(projectController: ProjectController) {
    while (true) {
        println(
            """
            Gestión de Proyectos:
            1. Crear proyecto
            2. Listar proyectos
            3. Volver al menú principal
            >>>>
            """.trimIndent(),
        )
        when (readln()) {
            "1" -> projectController.createProject()
            "2" -> projectController.displayProject()
            "3" -> return // Goes back to the main menu
            else -> println("Opción inválida, por favor intenta de nuevo.")
        }
    }
}
