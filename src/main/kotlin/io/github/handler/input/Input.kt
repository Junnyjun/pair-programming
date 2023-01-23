package io.github.handler.input

import kotlin.random.Random

interface Input {
    fun read(): InputData

    class Console : Input {
        override fun read(): InputData = readln()
            .also { Regex("""(\d)([LR])""").find(it) ?: throw IllegalArgumentException("입력값이 올바르지 않습니다. (입력값: $it)") }
            .let { InputData.with(it[0].digitToInt() to it[1]) }
    }

    class RandomValue : Input {
        override fun read(): InputData = InputData.with(count() to side())

        private fun count(): Int = Random.nextInt(6)
        private fun side(): Char = if (Random.nextBoolean()) 'L' else 'R'
    }

    data class InputData(
        val moveCount: Int,
        val side: Char
    ) {
        companion object {
            fun with(inputDate: Pair<Int, Char>): InputData = inputDate
                .let { (count, side) -> InputData(count, side) }
        }
    }
}