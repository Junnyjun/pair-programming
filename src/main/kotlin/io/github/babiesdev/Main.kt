package io.github.babiesdev

import java.util.*


fun main() {
    var flag = true
    var firstPlayer = Participant.Player(Position(0))
    val firstRabbit = Participant.Rabbit(Position(Random().nextInt(70)))

    while (flag) {
        readln()
            .also { Regex("""(\d)([LR])""").find(it) ?: throw IllegalArgumentException("입력값이 올바르지 않습니다. (입력값: $it)") }
            .let { it[0].digitToInt() to it[1] }
            .let { (digit, side) ->
                when (side) {
                    'L' -> firstPlayer =firstPlayer.leftMove(digit)
                    'R' -> firstPlayer =firstPlayer.rightMove(digit)
                    else -> throw IllegalArgumentException("입력값이 올바르지 않습니다. (입력값: $side)")
                }
            }
            .also { println("player :: ${firstPlayer.position.value}") }
            .let {
                when (Random().nextBoolean()) {
                    true -> firstRabbit.leftMove(Random().nextInt(6))
                    false -> firstRabbit.rightMove(Random().nextInt(6))
                }.also {
                    println("RABBIT :: ${it.position.value}")
                    if (firstPlayer.position.value == it.position.value) {
                        println("축하합니다! 당신이 이겼습니다.")
                        flag = false
                    }
                }
            }
    }


}