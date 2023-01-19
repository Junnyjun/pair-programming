package io.github.babiesdev

import java.util.*

fun main() {
    val firstPlayer = Participant.Player(Position(0))
    val firstRabbit = Participant.Rabbit(Position(Random().nextInt(70)))

    readln()
        .also { Regex("""(\d)([LR])""").find(it) ?: throw IllegalArgumentException("입력값이 올바르지 않습니다. (입력값: $it)") }
        .let { it[0].digitToInt() to it[1] }
        .let { (digit, side) ->
            when (side) {
                'L' -> firstPlayer.leftMove(digit)
                'R' -> firstPlayer.rightMove(digit)
                else -> throw IllegalArgumentException("입력값이 올바르지 않습니다. (입력값: $side)")
            }
        }
        .let {
                player ->
            when (Random().nextBoolean()) {
                true -> firstRabbit.leftMove(Random().nextInt(6))
                false -> firstRabbit.rightMove(Random().nextInt(6))
            }.also {
                if (player.position.value == it.position.value) throw IllegalArgumentException("축하합니다! 당신이 이겼습니다.")
            }
        }


}