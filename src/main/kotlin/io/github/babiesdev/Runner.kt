package io.github.babiesdev

import io.github.babiesdev.domain.DEFAULT_PLAYER
import io.github.babiesdev.domain.DEFAULT_RABBIT
import io.github.handler.input.Input
import java.util.*

class Runner {

    companion object {
        fun run() {
            var flag = true
            var firstPlayer = DEFAULT_PLAYER
            val firstRabbit = DEFAULT_RABBIT

            while (flag) {
                val read: Input.InputData = Input.Console().read()
                read.let { (digit, side) ->
                        when (side) {
                            'L' -> firstPlayer =firstPlayer.leftMove(digit)
                            'R' -> firstPlayer =firstPlayer.rightMove(digit)
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
    }
}