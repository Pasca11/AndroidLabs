data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

fun main() {
    print(Question(questionText="Quoth the raven ___", answer="nevermore", difficulty=Difficulty.MEDIUM))
}
