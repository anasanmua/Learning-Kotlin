package objects

import classes.Comment

object CommentManager {
    private var comment: Comment? = null

    fun createComment(): Comment {
        println("created by:")
        val createdBy = readln()
        println("description:")
        val description = readln()
        println("created on:")
        val createdOn = readln()
        return Comment(createdBy, description, createdOn)
    }

    fun getComment(): Comment? = comment
}

class CommentController {
    fun createComment() {
        CommentManager.createComment()
    }

    fun displayComment() {
        CommentManager.getComment()
    }
}
